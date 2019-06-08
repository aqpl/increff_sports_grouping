package com.amdocs.hackathon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

  @Autowired
  private UserDB userDB;

  public int validateAndGetDBPasswordHash(String password, String email) {
    String dbPassword = Helper.getMD5Hash(password);
    UserInfo userInfo = userDB.getUserInfo(email);
    if (!userInfo.password().equals(dbPassword)) {
      throw new AppException(ErrorCode.InvalidPassword);
    }
    return userInfo.type();
  }

  public int addUserInfo(UserInfo userInfo) {
    userDB.insertUserInfo(userInfo);
    return userInfo.type();
  }
}