package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class UserActivities {

  @Expose
  private String userEmail;
  @Expose
  private String ownerEmail;
  @Expose
  private String name;
  @Expose
  private int gameId;
  @Expose
  private double latitude;
  @Expose
  private double longitude;
  @Expose
  private int start;
  @Expose
  private int end;
  @Expose
  private String date;
  @Expose
  private int totalAllowed;
  @Expose
  private int totalRegistered;

  public String userEmail() {
    return this.userEmail;
  }

  public String ownerEmail() {
    return this.ownerEmail;
  }

  public String name() {
    return this.name;
  }

  public int gameId() {
    return this.gameId;
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

  public String date() {
    return this.date;
  }

  public int totalAllowed() {
    return this.totalAllowed;
  }

  public int totalRegistered() {
    return this.totalRegistered;
  }

  public UserActivities userEmail(final String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public UserActivities ownerEmail(final String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  public UserActivities name(final String name) {
    this.name = name;
    return this;
  }

  public UserActivities gameId(final int gameId) {
    this.gameId = gameId;
    return this;
  }

  public UserActivities latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public UserActivities longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  public UserActivities start(final int start) {
    this.start = start;
    return this;
  }

  public UserActivities end(final int end) {
    this.end = end;
    return this;
  }

  public UserActivities date(final String date) {
    this.date = date;
    return this;
  }

  public UserActivities totalAllowed(final int totalAllowed) {
    this.totalAllowed = totalAllowed;
    return this;
  }

  public UserActivities totalRegistered(final int totalRegistered) {
    this.totalRegistered = totalRegistered;
    return this;
  }

}
