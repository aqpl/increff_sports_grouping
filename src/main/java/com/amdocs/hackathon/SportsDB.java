package com.amdocs.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.amdocs.hackathon.DBQueries.TokenQuery.*;
import static com.amdocs.hackathon.DBQueries.TokenTables.*;

@Service
public class SportsDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private SportsMapper sportsMapper;
  @Autowired
  private ActivityMapper activityMapper;
  @Autowired
  private UserActivitiesMapper userActivitiesMapper;
  @Autowired
  private JoinActivityRequestMapper joinActivityRequestMapper;

  public List<Sports> getAllSports() {
    List<Sports> query = jdbcTemplate
      .query(GET_SPORTS,
        new MapSqlParameterSource(),
        sportsMapper);
    return query;
  }

  public List<Activity> checkActivity(String name, int gameid, String email) {
    return jdbcTemplate
      .query(GET_ACTIVITY_COUNT,
        new MapSqlParameterSource().addValue(SPORT_NAME, name)
          .addValue(GAME_ID, gameid)
          .addValue(EMAIL, email),
        activityMapper);
  }

  public void insertActivity(Activity activity) {
    jdbcTemplate.update(ADD_ACTIVITY,
      new MapSqlParameterSource().addValue(OWNER_NAME, activity.name())
        .addValue(GAME_ID, activity.gameid())
        .addValue(LATITUDE, activity.latitude())
        .addValue(LONGITUDE, activity.longitude())
        .addValue(START, activity.start())
        .addValue(END, activity.end())
        .addValue(EMAIL, activity.email()));
  }

  public List<Activity> getAllActivities(String email) {
    return jdbcTemplate.query(GET_ALL_ACTIVITIES,
      new MapSqlParameterSource().addValue(EMAIL, email), activityMapper);
  }

  public List<UserActivities> getActivitiesBookedTodayAfterCurrentTime(AllCreateActivitiesRequest request) {
    return jdbcTemplate.query(GET_ALL_ACTIVITIES_BOOKED_TODAY_AFTER_CURRENT_TIME,
      new MapSqlParameterSource().addValue(EMAIL, request.email())
        .addValue(START, request.startSearch())
        .addValue(DATE, request.today())
        .addValue(GAME_ID_LIST, request.integerList()), userActivitiesMapper);
  }

  public List<UserActivities> getActivitiesBookedTodayAfterCurrentTimeAndSeatsAvailable(AllCreateActivitiesRequest request) {
    return jdbcTemplate.query(GET_ALL_ACTIVITIES_BOOKED_TODAY_AFTER_CURRENT_TIME_AND_SEATS_AVL,
      new MapSqlParameterSource().addValue(EMAIL, request.email())
        .addValue(START, request.startSearch())
        .addValue(DATE, request.today())
        .addValue(GAME_ID_LIST, request.integerList()), userActivitiesMapper);
  }

  public List<Activity> getActivitiesAfterCurrentTime(long start, List<Integer> list) {
    return jdbcTemplate.query(GET_ACTIVITIES_WHICH_END_LATER,
      new MapSqlParameterSource().addValue(START, start)
        .addValue(GAME_ID_LIST, list), activityMapper);
  }

  public List<JoinActivityRequest> getUserActivitiesPart(String email) {
    return jdbcTemplate.query(GET_ALL_USER_PART_OF_ACTIVITIES,
      new MapSqlParameterSource().addValue(EMAIL, email)
        , joinActivityRequestMapper);
  }



  public void insertUserActivity(CreateActivityRequest request) {
    jdbcTemplate.update(ADD_USER_ACTIVITY,
      new MapSqlParameterSource().addValue(USER_EMAIL, request.userEmail())
        .addValue(OWNER_EMAIL, request.ownerEmail())
        .addValue(OWNER_NAME, request.name())
        .addValue(GAME_ID, request.gameid())
        .addValue(LATITUDE, request.latitude())
        .addValue(LONGITUDE, request.longitude())
        .addValue(START, request.start())
        .addValue(END, request.end())
        .addValue(DATE, request.date())
        .addValue(TOTAL_ALLOWED, request.totalAllowed())
        .addValue(REGISTERED, request.registered()));
  }

  public void joinActivity(JoinActivityRequest request) {
    jdbcTemplate.update(INSERT_USER_ACTIVITY,
      new MapSqlParameterSource().addValue(USER_EMAIL, request.userEmail())
        .addValue(OWNER_EMAIL, request.ownerEmail())
        .addValue(OWNER_NAME, request.name())
        .addValue(GAME_ID, request.gameid())
        .addValue(LATITUDE, request.latitude())
        .addValue(LONGITUDE, request.longitude())
        .addValue(START, request.start())
        .addValue(END, request.end())
        .addValue(DATE, request.date())
        .addValue(EMAIL, request.email()));
  }

  public void updateRegisteredCount(JoinActivityRequest request) {
    jdbcTemplate.update(UPDATE_REGISTERED_COUNT,
      new MapSqlParameterSource()
        .addValue(DATE, request.date())
        .addValue(USER_EMAIL, request.userEmail())
        .addValue(OWNER_EMAIL, request.ownerEmail())
        .addValue(OWNER_NAME, request.name())
        .addValue(GAME_ID, request.gameid())
        .addValue(START, request.start())
        .addValue(END, request.end()));
  }
}

