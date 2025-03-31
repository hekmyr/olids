package dev.hekmyr.olids.api.model;

public enum ErrorCodes {
  EMAIL_ALREADY_EXISTS("email_already_exists"),
  WEAK_PASSWORD("weak_password"),
  PASSWORD_MISMATCH("password_mismatch");

  private final String code;

  ErrorCodes(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
} 