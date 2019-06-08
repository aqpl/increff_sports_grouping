package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class AllCreateActivitiesRequest {

  //client
  @Expose
  private String email;
  //client
  @Expose
  private List<Integer> integerList = new ArrayList<>(1);
  //client
  @Expose
  private double radius;
  //client
  @Expose
  private double latitude;
  //client
  @Expose
  private double longitude;
  @Expose
  private String today;
  @Expose
  private int startSearch;

  public String email() {
    return this.email;
  }

  public List<Integer> integerList() {
    return this.integerList;
  }

  public double radius() {
    return this.radius;
  }

  public double latitude() {
    return this.latitude;
  }

  public double longitude() {
    return this.longitude;
  }

  public String today() {
    return this.today;
  }

  public int startSearch() {
    return this.startSearch;
  }

  public AllCreateActivitiesRequest email(final String email) {
    this.email = email;
    return this;
  }

  public AllCreateActivitiesRequest integerList(final List<Integer> integerList) {
    this.integerList = integerList;
    return this;
  }

  public AllCreateActivitiesRequest radius(final double radius) {
    this.radius = radius;
    return this;
  }

  public AllCreateActivitiesRequest latitude(final double latitude) {
    this.latitude = latitude;
    return this;
  }

  public AllCreateActivitiesRequest longitude(final double longitude) {
    this.longitude = longitude;
    return this;
  }

  public AllCreateActivitiesRequest today(final String today) {
    this.today = today;
    return this;
  }

  public AllCreateActivitiesRequest startSearch(final int startSearch) {
    this.startSearch = startSearch;
    return this;
  }

}
