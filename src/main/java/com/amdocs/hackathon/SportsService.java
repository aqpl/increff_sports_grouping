package com.amdocs.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.amdocs.hackathon.Helper.getDistanceInKm;
import static com.amdocs.hackathon.Helper.parseTime;
import static java.util.Objects.isNull;

@Service
public class SportsService {

  @Autowired
  private SportsDB sportsDB;

  public List<Sports> sportsList() {
    return sportsDB.getAllSports();
  }

  boolean isPresent(Activity activity) {
    List<Activity> activities = sportsDB.checkActivity(activity.name(), activity.gameid(), activity.email());
    int start = activity.start();
    int end = activity.end();
    for (Activity activity1 : activities) {
      if ((activity1.start() >= start && activity1.end() > start) || (activity1.end() >= end && activity1.start() > end)) {
        return false;
      }
    }
    return true;
  }

  public void insertActivity(Activity activity) {
    sportsDB.insertActivity(activity);
  }

  public List<ResponseActivity> getAllActivities(String email) {
    List<Activity> allActivities = sportsDB.getAllActivities(email);
    List<ResponseActivity> responseActivities = new ArrayList<>();
    for (int i = 0; i < allActivities.size(); i++) {
      Activity activity = allActivities.get(i);
      ResponseActivity responseActivity = new ResponseActivity()
        .email(activity.email())
        .gameid(activity.gameid())
        .endString(parseTime(activity.end()))
        .startString(parseTime(activity.start()))
        .name(activity.name())
        .latitude(activity.latitude())
        .longitude(activity.longitude());
      responseActivities.add(responseActivity);
    }
    return responseActivities;
  }

  public List<UserActivities> getActivitiesWithinRadius(List<UserActivities> activities, double radius, double lat, double longitude) {
    List<UserActivities> newActivities = new ArrayList<>(1);
    for (int i = 0; i < activities.size(); i++) {
      UserActivities userActivities = activities.get(i);
      if (getDistanceInKm(userActivities.latitude(), userActivities.longitude(), lat, longitude) <= radius) {
        newActivities.add(userActivities);
      }
    }
    return newActivities;
  }

  public List<ActivitiesToCreate> getActivitiesToCreate(AllCreateActivitiesRequest activitiesRequest) {
    if (isNull(activitiesRequest.integerList()) || activitiesRequest.integerList().size() == 0) {
      List<Sports> sports = sportsList();
      List<Integer> idList = new ArrayList<>();
      for (Sports sports1 : sports) {
        idList.add(sports1.id());
      }
      activitiesRequest.integerList(idList);
    }
    List<UserActivities> userActivities = sportsDB.getActivitiesBookedTodayAfterCurrentTime(activitiesRequest);
    userActivities = getActivitiesWithinRadius(userActivities, activitiesRequest.radius(), activitiesRequest.latitude(), activitiesRequest.longitude());
    List<Activity> activitiesAfterCurrentTime = sportsDB.getActivitiesAfterCurrentTime(activitiesRequest.startSearch(), activitiesRequest.integerList());
    return getActivitiesUserCanCreate(activitiesAfterCurrentTime, userActivities, activitiesRequest);
  }

  private List<ActivitiesToCreate> getActivitiesUserCanCreate(List<Activity> activitiesAfterCurrentTime, List<UserActivities> userActivities, AllCreateActivitiesRequest request) {
    List<ActivitiesToCreate> activitiesToCreate = new ArrayList<>();
    for (int i = 0; i < activitiesAfterCurrentTime.size(); i++) {
      Activity activity = activitiesAfterCurrentTime.get(i);
      int[] visited = new int[24];
      for (int j = 0; j < userActivities.size(); j++) {
        UserActivities userActivities1 = userActivities.get(j);
        if (userActivities1.gameId() == activity.gameid() && userActivities1.name().equals(activity.name()) && userActivities1.ownerEmail().equals(activity.email())) {
          for (int k = userActivities1.start(); k < userActivities1.end(); k++) {
            visited[k] = 1;
          }
        }
      }
      int ns = Math.max(request.startSearch()+1, activity.start());
      int taken = 0;
      while (ns < activity.end()) {
        if (visited[ns] == 0) {
          taken++;
          ns++;
        } else {
          if (taken > 0) {
            ActivitiesToCreate activitiesToCreate1 = new ActivitiesToCreate()
              .distance(getDistanceInKm(activity.latitude(), activity.longitude(), request.latitude(), request.longitude()))
              .end(ns)
              .start(ns - taken)
              .gameid(activity.gameid())
              .ownerEmail(activity.email())
              .name(activity.name());
            activitiesToCreate.add(activitiesToCreate1);
          }
          taken = 0;
          ns++;
        }
      }
      if (taken > 0) {
        ActivitiesToCreate activitiesToCreate1 = new ActivitiesToCreate()
          .distance(getDistanceInKm(activity.latitude(), activity.longitude(), request.latitude(), request.longitude()))
          .end(ns)
          .start(ns - taken)
          .gameid(activity.gameid())
          .ownerEmail(activity.email())
          .name(activity.name());
        activitiesToCreate.add(activitiesToCreate1);
      }
    }
    return activitiesToCreate;
  }

  public void createActivity(CreateActivityRequest request) {
    sportsDB.insertUserActivity(request);
    JoinActivityRequest joinActivityRequest = new JoinActivityRequest()
      .date(request.date())
      .email(request.userEmail())
      .userEmail(request.userEmail())
      .end(request.end())
      .start(request.start())
      .ownerEmail(request.ownerEmail())
      .name(request.name())
      .gameid(request.gameid())
      .latitude(request.latitude())
      .longitude(request.longitude());
    sportsDB.joinActivity(joinActivityRequest);
  }

  public List<JoinUserActivities> getActivitiesToJoin(AllCreateActivitiesRequest activitiesRequest) {
    if (isNull(activitiesRequest.integerList()) || activitiesRequest.integerList().size() == 0) {
      List<Sports> sports = sportsList();
      List<Integer> idList = new ArrayList<>();
      for (Sports sports1 : sports) {
        idList.add(sports1.id());
      }
      activitiesRequest.integerList(idList);
    }
    List<UserActivities> userActivities = sportsDB.getActivitiesBookedTodayAfterCurrentTimeAndSeatsAvailable(activitiesRequest);
    List<JoinActivityRequest> userActivitiesPart = sportsDB.getUserActivitiesPart(activitiesRequest.email());
    List<JoinUserActivities> joinUserActivities = new ArrayList<>();
    for (int i = 0; i < userActivities.size(); i++) {
      UserActivities userActivities1 = userActivities.get(i);
      if (getDistanceInKm(activitiesRequest.latitude(), activitiesRequest.longitude(), userActivities1.latitude(), userActivities1.longitude()) < activitiesRequest.radius() && validateJoin(userActivitiesPart, userActivities1)) {
        JoinUserActivities joinUserActivities1 = new JoinUserActivities()
          .end(userActivities1.end())
          .gameId(userActivities1.gameId())
          .name(userActivities1.name())
          .ownerEmail(userActivities1.ownerEmail())
          .radius(getDistanceInKm(activitiesRequest.latitude(), activitiesRequest.longitude(), userActivities1.latitude(), userActivities1.longitude()))
          .totalAllowed(userActivities1.totalAllowed())
          .totalRegistered(userActivities1.totalRegistered())
          .start(userActivities1.start())
          .userEmail(userActivities1.userEmail());
        joinUserActivities.add(joinUserActivities1);
      }
    }
    return joinUserActivities;
  }

  private boolean validateJoin(List<JoinActivityRequest> userActivitiesPart, UserActivities userActivities1) {
    for(int i = 0; i< userActivitiesPart.size(); i++) {
      JoinActivityRequest joinActivityRequest = userActivitiesPart.get(i);
      if(userActivities1.date().equals(joinActivityRequest.date()) && userActivities1.ownerEmail().equals(joinActivityRequest.ownerEmail()) &&
      userActivities1.userEmail().equals(joinActivityRequest.userEmail()) && userActivities1.gameId() == joinActivityRequest.gameid() &&
      userActivities1.name().equals(joinActivityRequest.name()) && userActivities1.start() == joinActivityRequest.start() && userActivities1.end() == joinActivityRequest.end()) {
        return false;
      }
    }
    return true;
  }

  public void joinActivity(JoinActivityRequest request) {
    sportsDB.joinActivity(request);
    sportsDB.updateRegisteredCount(request);
  }
}
