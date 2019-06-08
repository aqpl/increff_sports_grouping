package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class UserInfo {

  @Expose
  private String email;
  @Expose
  private int type;
  @Expose
  private String password;
  @Expose
  private int age;
  @Expose
  private String gender;
  private long createdAt;
  private long updatedAt;

  public String email() {
    return this.email;
  }

  public int type() {
    return this.type;
  }

  public String password() {
    return this.password;
  }

  public int age() {
    return this.age;
  }

  public String gender() {
    return this.gender;
  }

  public long createdAt() {
    return this.createdAt;
  }

  public long updatedAt() {
    return this.updatedAt;
  }

  public UserInfo email(final String email) {
    this.email = email;
    return this;
  }

  public UserInfo type(final int type) {
    this.type = type;
    return this;
  }

  public UserInfo password(final String password) {
    this.password = password;
    return this;
  }

  public UserInfo age(final int age) {
    this.age = age;
    return this;
  }

  public UserInfo gender(final String gender) {
    this.gender = gender;
    return this;
  }

  public UserInfo createdAt(final long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public UserInfo updatedAt(final long updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }


}
