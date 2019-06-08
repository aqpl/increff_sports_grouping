package com.amdocs.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import static com.amdocs.hackathon.Helper.getMD5Hash;

@Service
public class UserDB {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  @Autowired
  private AccessTokenMapper accessTokenMapper;

  public UserInfo getUserInfo(String email) {
    try {
      return jdbcTemplate
          .queryForObject(DBQueries.TokenQuery.GET_USER_INFO,
              new MapSqlParameterSource().addValue(DBQueries.TokenTables.EMAIL, email),
              accessTokenMapper);
    } catch (EmptyResultDataAccessException ex) {
      throw new AppException(ErrorCode.EmailNotExists);
    }
  }

  public int isPresent(String email) {
    return jdbcTemplate
      .queryForObject(DBQueries.TokenQuery.GET_COUNT,
        new MapSqlParameterSource().addValue(DBQueries.TokenTables.EMAIL, email),
        Integer.class);
  }

  public void insertUserInfo(UserInfo userInfo) {
    jdbcTemplate.update(DBQueries.TokenQuery.ADD_USER_INFO,
      new MapSqlParameterSource().addValue(DBQueries.TokenTables.EMAIL, userInfo.email())
        .addValue(DBQueries.TokenTables.TYPE, userInfo.type())
        .addValue(DBQueries.TokenTables.PASSWORD, getMD5Hash(userInfo.password()))
        .addValue(DBQueries.TokenTables.AGE, userInfo.age())
        .addValue(DBQueries.TokenTables.GENDER, userInfo.gender()));
  }

}
