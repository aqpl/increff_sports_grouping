package com.amdocs.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AccessTokenMapper implements RowMapper<UserInfo> {
  @Override
  public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
    UserInfo userInfo = new UserInfo()
        .email(resultSet.getString(DBQueries.TokenTables.EMAIL))
        .type(resultSet.getInt(DBQueries.TokenTables.TYPE))
        .password(resultSet.getString(DBQueries.TokenTables.PASSWORD));
    return userInfo;
  }
}
