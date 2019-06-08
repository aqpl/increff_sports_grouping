package com.amdocs.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.amdocs.hackathon.DBQueries.TokenTables.*;

@Component
public class ActivityMapper implements RowMapper<Activity> {
  @Override
  public Activity mapRow(ResultSet resultSet, int i) throws SQLException {
    Activity activity = new Activity()
      .email(resultSet.getString(EMAIL))
      .end(resultSet.getInt(END))
      .gameid(resultSet.getInt(GAME_ID))
      .start(resultSet.getInt(START))
      .latitude(resultSet.getDouble(LATITUDE))
      .longitude(resultSet.getDouble(LONGITUDE))
      .name(resultSet.getString(OWNER_NAME));
    return activity;
  }
}
