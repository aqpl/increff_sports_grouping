package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class JoinActivityRequest {

  @Expose
  private String email;
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

  public String email() {
    return this.email;
  }

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

  public JoinActivityRequest email(final String email) {
    this.email = email;
    return this;
  }

  public JoinActivityRequest userEmail(final String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public JoinActivityRequest ownerEmail(final String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  public JoinActivityRequest name(final String name) {
    this.name = name;
    return this;
  }

  public JoinActivityRequest gameid(final int gameid) {
    this.gameid = gameid;
    return this;
  }

  public JoinActivityRequest latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public JoinActivityRequest longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  public JoinActivityRequest start(final int start) {
    this.start = start;
    return this;
  }

  public JoinActivityRequest end(final int end) {
    this.end = end;
    return this;
  }

  public JoinActivityRequest date(final String date) {
    this.date = date;
    return this;
  }

}
