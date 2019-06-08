package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class Activity {

  @Expose
  private String email;
  @Expose
  private String name;
  @Expose
  private int gameid;
  @Expose
  private double latitude;
  @Expose
  private double longitude;
  @Expose
  private int start;
  @Expose
  private int end;

  public String email() {
    return this.email;
  }

  public String name() {
    return this.name;
  }

  public int gameid() {
    return this.gameid;
  }

  public double latitude() {
    return this.latitude;
  }

  public double longitude() {
    return this.longitude;
  }

  public int start() {
    return this.start;
  }

  public int end() {
    return this.end;
  }

  public Activity email(final String email) {
    this.email = email;
    return this;
  }

  public Activity name(final String name) {
    this.name = name;
    return this;
  }

  public Activity gameid(final int gameid) {
    this.gameid = gameid;
    return this;
  }

  public Activity latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public Activity longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  public Activity start(final int start) {
    this.start = start;
    return this;
  }

  public Activity end(final int end) {
    this.end = end;
    return this;
  }

}
