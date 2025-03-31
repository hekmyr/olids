package dev.hekmyr.olids.api.dto;

public class ErrorResponseDTO {
  private String errorCode;

  public ErrorResponseDTO(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
} 