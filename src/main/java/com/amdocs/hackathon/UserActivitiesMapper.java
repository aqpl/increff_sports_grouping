package com.amdocs.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.amdocs.hackathon.DBQueries.TokenTables.*;

@Component
public class UserActivitiesMapper implements RowMapper<UserActivities> {

  @Override
  public UserActivities mapRow(ResultSet resultSet, int i) throws SQLException {
    UserActivities activity = new UserActivities()
      .userEmail(resultSet.getString(USER_EMAIL))
      .ownerEmail(resultSet.getString(OWNER_EMAIL))
      .name(resultSet.getString(OWNER_NAME))
      .gameId(resultSet.getInt(GAME_ID))
      .start(resultSet.getInt(START))
      .latitude(resultSet.getDouble(LATITUDE))
      .longitude(resultSet.getDouble(LONGITUDE))
      .end(resultSet.getInt(END))
      .date(resultSet.getString(DATE))
      .totalAllowed(resultSet.getInt(TOTAL_ALLOWED))
      .totalRegistered(resultSet.getInt(REGISTERED));
    return activity;
  }
}
