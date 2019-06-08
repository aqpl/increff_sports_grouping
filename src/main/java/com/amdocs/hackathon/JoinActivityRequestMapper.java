package com.amdocs.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.amdocs.hackathon.DBQueries.TokenTables.*;

@Component
public class JoinActivityRequestMapper implements RowMapper<JoinActivityRequest> {
  @Override
  public JoinActivityRequest mapRow(ResultSet resultSet, int i) throws SQLException {
    JoinActivityRequest activity = new JoinActivityRequest()
      .email(resultSet.getString(EMAIL))
      .userEmail(resultSet.getString(USER_EMAIL))
      .ownerEmail(resultSet.getString(OWNER_EMAIL))
      .name(resultSet.getString(OWNER_NAME))
      .gameid(resultSet.getInt(GAME_ID))
      .latitude(resultSet.getDouble(LATITUDE))
      .longitude(resultSet.getDouble(LONGITUDE))
      .end(resultSet.getInt(END))
      .start(resultSet.getInt(START))
      .date(resultSet.getString(DATE));
    return activity;
  }
}

