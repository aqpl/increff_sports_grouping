package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class JoinUserActivities {

  @Expose
  private String email;
  @Expose
  private String userEmail;
  @Expose
  private String ownerEmail;
  @Expose
  private String name;
  @Expose
  private int gameId;
  @Expose
  private double radius;
  @Expose
  private int start;
  @Expose
  private int end;
  @Expose
  private int totalAllowed;
  @Expose
  private int totalRegistered;

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

  public int gameId() {
    return this.gameId;
  }

  public double radius() {
    return this.radius;
  }

  public int start() {
    return this.start;
  }

  public int end() {
    return this.end;
  }

  public int totalAllowed() {
    return this.totalAllowed;
  }

  public int totalRegistered() {
    return this.totalRegistered;
  }

  public JoinUserActivities email(final String email) {
    this.email = email;
    return this;
  }

  public JoinUserActivities userEmail(final String userEmail) {
    this.userEmail = userEmail;
    return this;
  }

  public JoinUserActivities ownerEmail(final String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  public JoinUserActivities name(final String name) {
    this.name = name;
    return this;
  }

  public JoinUserActivities gameId(final int gameId) {
    this.gameId = gameId;
    return this;
  }

  public JoinUserActivities radius(final double radius) {
    this.radius = radius;
    return this;
  }

  public JoinUserActivities start(final int start) {
    this.start = start;
    return this;
  }

  public JoinUserActivities end(final int end) {
    this.end = end;
    return this;
  }

  public JoinUserActivities totalAllowed(final int totalAllowed) {
    this.totalAllowed = totalAllowed;
    return this;
  }

  public JoinUserActivities totalRegistered(final int totalRegistered) {
    this.totalRegistered = totalRegistered;
    return this;
  }


}
