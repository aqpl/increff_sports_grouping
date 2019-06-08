package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class CreateActivityRequest {

  @Expose
  private String userEmail;
  @Expose
  private String ownerEmail;
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
  // this I will populate (Not from client)
  @Expose
  private String date;
  @Expose
  private int totalAllowed;
  // not to be done by client
  @Expose
  private int registered;

  public String userEmail() {
    return this.userEmail;
  }

  public String ownerEmail() {
    return this.ownerEmail;
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

  public String date() {
    return this.date;
  }

  public int totalAllowed() {
    return this.totalAllowed;
  }

  public int registered() {
    return this.registered;
  }

  public CreateActivityRequest userEmail(final String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public CreateActivityRequest ownerEmail(final String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  public CreateActivityRequest name(final String name) {
    this.name = name;
    return this;
  }

  public CreateActivityRequest gameid(final int gameid) {
    this.gameid = gameid;
    return this;
  }

  public CreateActivityRequest latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public CreateActivityRequest longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  public CreateActivityRequest start(final int start) {
    this.start = start;
    return this;
  }

  public CreateActivityRequest end(final int end) {
    this.end = end;
    return this;
  }

  public CreateActivityRequest date(final String date) {
    this.date = date;
    return this;
  }

  public CreateActivityRequest totalAllowed(final int totalAllowed) {
    this.totalAllowed = totalAllowed;
    return this;
  }

  public CreateActivityRequest registered(final int registered) {
    this.registered = registered;
    return this;
  }
}
