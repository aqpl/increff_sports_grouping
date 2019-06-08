package com.amdocs.hackathon;

public enum ErrorCode {

  Unauthorized(405),
  InvalidPassword(400),
  EmailNotExists(401),
  EmailAlreadyExists(402),
  ActivityAlreadyExists(403),
  InternalServerError(500);

  int statusCode;

  ErrorCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public int statusCode() {
    return statusCode;
  }
}
