package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class ValidateRequest {
  @Expose
  private String email;
  @Expose
  private String password;

  public String email() {
    return this.email;
  }

  public String password() {
    return this.password;
  }

  public ValidateRequest email(final String email) {
    this.email = email;
    return this;
  }

  public ValidateRequest password(final String password) {
    this.password = password;
    return this;
  }
}
