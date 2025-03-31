package dev.hekmyr.olids.api.model;

public enum ErrorCodes {
  EMAIL_ALREADY_EXISTS("email_already_exists"),
  WEAK_PASSWORD("weak_password"),
  PASSWORD_MISMATCH("password_mismatch");

  private final String message;

  ErrorCodes(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
} 