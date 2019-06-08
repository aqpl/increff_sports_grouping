package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class ActivitiesToCreate {

  @Expose
  private String ownerEmail;
  @Expose
  private String name;
  @Expose
  private int gameid;
  @Expose
  private double distance;
  @Expose
  private int start;
  @Expose
  private int end;

  public String ownerEmail() {
    return this.ownerEmail;
  }

  public String name() {
    return this.name;
  }

  public int gameid() {
    return this.gameid;
  }

  public double distance() {
    return this.distance;
  }

  public int start() {
    return this.start;
  }

  public int end() {
    return this.end;
  }

  public ActivitiesToCreate ownerEmail(final String ownerEmail) {
    this.ownerEmail = ownerEmail;
    return this;
  }

  public ActivitiesToCreate name(final String name) {
    this.name = name;
    return this;
  }

  public ActivitiesToCreate gameid(final int gameid) {
    this.gameid = gameid;
    return this;
  }

  public ActivitiesToCreate distance(final double distance) {
    this.distance = distance;
    return this;
  }

  public ActivitiesToCreate start(final int start) {
    this.start = start;
    return this;
  }

  public ActivitiesToCreate end(final int end) {
    this.end = end;
    return this;
  }


}
