package com.amdocs.hackathon;

public class DBQueries {

  public interface TokenTables {
    String EMAIL = "email";
    String PASSWORD = "password";
    String TYPE = "type";
    String AGE = "age";
    String GENDER = "gender";
    String UPDATED_AT = "updated_at";
    String CREATED_AT = "created_at";
    String SPORT_NAME = "name";
    String SPORT_ID = "id";
    String GAME_ID = "gameid";
    String OWNER_NAME = "name";
    String START = "start";
    String END = "end";
    String DATE = "date";
    String LATITUDE = "latitude";
    String LONGITUDE = "longitude";
    String USER_EMAIL = "user_email";
    String OWNER_EMAIL = "owner_email";
    String TOTAL_ALLOWED = "total_allowed";
    String REGISTERED = "registered";
    String GAME_ID_LIST = "gameIdList";
  }

  public interface TokenQuery {
    String GET_USER_INFO = "SELECT email, password, type " +
        "FROM users WHERE email = :email";
    String GET_COUNT = "SELECT COUNT(*) FROM users WHERE email = :email";
    String GET_ACTIVITY_COUNT = "SELECT * FROM activities WHERE email = :email AND name = :name AND gameid = :gameid";
    String ADD_USER_INFO = "INSERT INTO users (email, type, password, age, gender) VALUES(:email, :type, :password, :age, :gender)";
    String ADD_ACTIVITY = "INSERT INTO activities (email, name, gameid, latitude, longitude, start, end) VALUES(:email, :name, :gameid, :latitude, :longitude, :start, :end)";
    String GET_SPORTS = "SELECT * from sports";
    String GET_ALL_ACTIVITIES = "Select * FROM activities WHERE email = :email";
    String GET_ALL_ACTIVITIES_BOOKED_TODAY_AFTER_CURRENT_TIME = "SELECT * FROM user_activities WHERE user_email != :email AND end > :start AND date = :date AND gameid IN (:gameIdList)";
    String GET_ALL_ACTIVITIES_BOOKED_TODAY_AFTER_CURRENT_TIME_AND_SEATS_AVL = "SELECT * FROM user_activities WHERE user_email != :email AND end > :start AND date = :date AND registered < total_allowed AND gameid IN (:gameIdList)";
    String GET_ACTIVITIES_WHICH_END_LATER = "SELECT * FROM activities WHERE end > :start AND gameid IN (:gameIdList)";
    String ADD_USER_ACTIVITY = "INSERT INTO user_activities (user_email, owner_email, name, gameid, latitude, longitude, start, end, date, total_allowed, registered) VALUES(:user_email, :owner_email, :name, :gameid, :latitude, :longitude, :start, :end, :date, :total_allowed, :registered)";
    String INSERT_USER_ACTIVITY = "INSERT INTO user_part_of_activities (email, user_email, owner_email, name, gameid, latitude, longitude, start, end, date) VALUES(:email, :user_email, :owner_email, :name, :gameid, :latitude, :longitude, :start, :end, :date)";
    String UPDATE_REGISTERED_COUNT = "UPDATE user_activities SET registered = registered + 1 WHERE date = :date AND user_email = :user_email AND owner_email = :owner_email AND name = :name AND gameid = :gameid AND start = :start AND end = :end";
    String GET_ALL_USER_PART_OF_ACTIVITIES = "SELECT * FROM user_activities WHERE email = :email";
  }
}