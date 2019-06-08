package com.amdocs.hackathon;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SportsMapper implements RowMapper<Sports> {
  @Override
  public Sports mapRow(ResultSet resultSet, int i) throws SQLException {
    Sports sports = new Sports()
      .name(resultSet.getString(DBQueries.TokenTables.SPORT_NAME))
      .id(resultSet.getInt(DBQueries.TokenTables.SPORT_ID));
    return sports;
  }

}
