package com.amdocs.hackathon;

import com.google.gson.annotations.Expose;

public class Sports {

  @Expose
  private String name;
  @Expose
  private int id;

  public String name() {
    return this.name;
  }

  public int id() {
    return this.id;
  }

  public Sports name(final String name) {
    this.name = name;
    return this;
  }

  public Sports id(final int id) {
    this.id = id;
    return this;
  }

}
