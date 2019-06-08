package com.amdocs.hackathon;

import com.google.gson.annotations.SerializedName;

public class SendMessageRequest {
  @SerializedName("to")
  String to;
  @SerializedName("subject")
  String Subject;
  @SerializedName("body")
  String Body;
  @SerializedName("from")
  String from;

  public String from() {
    return this.from;
  }

  public String to() {
    return this.to;
  }

  public String Subject() {
    return this.Subject;
  }

  public String Body() {
    return this.Body;
  }

  public SendMessageRequest to(final String to) {
    this.to = to;
    return this;
  }

  public SendMessageRequest Subject(final String Subject) {
    this.Subject = Subject;
    return this;
  }

  public SendMessageRequest Body(final String Body) {
    this.Body = Body;
    return this;
  }

  public SendMessageRequest from(final String from) {
    this.from = from;
    return this;
  }
}
