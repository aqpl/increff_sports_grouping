package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class ResponseActivity {

  @Expose
  private String startString;
  @Expose
  private String endString;
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

  public String startString() {
    return this.startString;
  }

  public String endString() {
    return this.endString;
  }

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

  public ResponseActivity startString(final String startString) {
    this.startString = startString;
    return this;
  }

  public ResponseActivity endString(final String endString) {
    this.endString = endString;
    return this;
  }

  public ResponseActivity email(final String email) {
    this.email = email;
    return this;
  }

  public ResponseActivity name(final String name) {
    this.name = name;
    return this;
  }

  public ResponseActivity gameid(final int gameid) {
    this.gameid = gameid;
    return this;
  }

  public ResponseActivity latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public ResponseActivity longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }
}
