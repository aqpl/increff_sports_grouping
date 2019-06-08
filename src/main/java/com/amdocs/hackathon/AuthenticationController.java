package com.amdocs.hackathon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

  @Autowired
  private AuthenticationService authenticationService;
  @Autowired
  private UserDB userDB;

  @PostMapping("/login")
  public int authenticate(@RequestBody ValidateRequest request) {
    String password = request.password();
    String email = request.email();
    return authenticationService.validateAndGetDBPasswordHash(password, email);
  }

  @PostMapping("/signUp")
  public int signup(@RequestBody UserInfo userInfo) {
    if (userDB.isPresent(userInfo.email()) > 0) {
      throw new AppException(ErrorCode.EmailAlreadyExists);
    }
    return authenticationService.addUserInfo(userInfo);
  }

}
