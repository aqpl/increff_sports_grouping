package com.amdocs.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.amdocs.hackathon.Helper.getCurrentDay;
import static com.amdocs.hackathon.Helper.getCurrentHour;

@RestController
public class SportsController {

  @Autowired
  private SportsService sportsService;

  @GetMapping("/status")
  public String healthCheck() {
    return "OK";
  }

  @GetMapping("/getAllSports")
  public List<Sports> getAllSports() {
    return sportsService.sportsList();
  }

  @PostMapping("/register")
  public void registerActivity(@RequestBody Activity activity) {
    if (sportsService.isPresent(activity)) {
      throw new AppException(ErrorCode.ActivityAlreadyExists);
    }
    sportsService.insertActivity(activity);
  }

  @PostMapping("/getAllActivities")
  public List<ResponseActivity> getAllActivities(@RequestBody Email email) {
    return sportsService.getAllActivities(email.email());
  }

  @PostMapping("/getActivitiesToCreate")
  public List<ActivitiesToCreate> getActivitiesToCreate(@RequestBody AllCreateActivitiesRequest activitiesRequest) {
    activitiesRequest.startSearch(getCurrentHour());
    activitiesRequest.today(getCurrentDay());
    return sportsService.getActivitiesToCreate(activitiesRequest);
  }

  @PostMapping("/createActivity")
  public void createActivity(@RequestBody CreateActivityRequest request) {
    request.date(getCurrentDay());
    request.registered(1);
    sportsService.createActivity(request);
  }

  @PostMapping("/getActivitiesToJoin")
  public List<JoinUserActivities> getActivitiesToJoin(@RequestBody AllCreateActivitiesRequest activitiesRequest) {
    activitiesRequest.startSearch(getCurrentHour());
    activitiesRequest.today(getCurrentDay());
    return sportsService.getActivitiesToJoin(activitiesRequest);
  }

  @PostMapping("/joinActivity")
  public void joinActivity(@RequestBody JoinActivityRequest request) {
    request.date(getCurrentDay());
    sportsService.joinActivity(request);
  }

  @PostMapping("/getAllActivitiesOfUser")
  public List<JoinActivityRequest> getAllUserActivities(@RequestBody Email email) {
    return sportsService.getAllUserActivities(email.email(), getCurrentDay(), getCurrentHour());
  }


}
