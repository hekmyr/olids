package dev.hekmyr.olids.api.model;

public class MessageResponseModel {

  private String message;

  public MessageResponseModel() {}

  public MessageResponseModel(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
