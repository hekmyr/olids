package dev.hekmyr.olids.api.dto;

public class ContactRequestDTO {

  private String Email;
  private String Subject;
  private String Message;

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getSubject() {
    return Subject;
  }

  public void setSubject(String subject) {
    Subject = subject;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String message) {
    Message = message;
  }
}
