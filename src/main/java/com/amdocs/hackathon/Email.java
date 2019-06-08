package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class Email {

  @Expose
  private String email;

  public String email() {
    return this.email;
  }

  public Email email(final String email) {
    this.email = email;
    return this;
  }

}
