package dev.hekmyr.olids.api.dto;

import dev.hekmyr.olids.api.entity.Accessibility;
import java.util.UUID;

public class AccessibilityDTO {

  private UUID id;
  private boolean toiletGrabBarAvailable;
  private boolean showerGrabBarAvailable;
  private boolean stepFreeShowerAvailable;
  private boolean showerBathChairAvailable;
  private boolean stepFreeBedroomAccessAvailable;
  private boolean wideBedroomEntranceAvailable;
  private boolean stepFreeAccessAvailable;

  public AccessibilityDTO() {}

  public AccessibilityDTO(Accessibility model) {
    this.id = model.getId();
    this.toiletGrabBarAvailable = model.isToiletGrabBarAvailable();
    this.showerGrabBarAvailable = model.isShowerGrabBarAvailable();
    this.stepFreeShowerAvailable = model.isStepFreeShowerAvailable();
    this.showerBathChairAvailable = model.isShowerBathChairAvailable();
    this.stepFreeBedroomAccessAvailable =
      model.isStepFreeBedroomAccessAvailable();
    this.wideBedroomEntranceAvailable =
      model.isWideBedroomEntranceAvailable();
    this.stepFreeAccessAvailable = model.isStepFreeAccessAvailable();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public boolean isToiletGrabBarAvailable() {
    return toiletGrabBarAvailable;
  }

  public void setToiletGrabBarAvailable(boolean toiletGrabBarAvailable) {
    this.toiletGrabBarAvailable = toiletGrabBarAvailable;
  }

  public boolean isShowerGrabBarAvailable() {
    return showerGrabBarAvailable;
  }

  public void setShowerGrabBarAvailable(boolean showerGrabBarAvailable) {
    this.showerGrabBarAvailable = showerGrabBarAvailable;
  }

  public boolean isStepFreeShowerAvailable() {
    return stepFreeShowerAvailable;
  }

  public void setStepFreeShowerAvailable(boolean stepFreeShowerAvailable) {
    this.stepFreeShowerAvailable = stepFreeShowerAvailable;
  }

  public boolean isShowerBathChairAvailable() {
    return showerBathChairAvailable;
  }

  public void setShowerBathChairAvailable(boolean showerBathChairAvailable) {
    this.showerBathChairAvailable = showerBathChairAvailable;
  }

  public boolean isStepFreeBedroomAccessAvailable() {
    return stepFreeBedroomAccessAvailable;
  }

  public void setStepFreeBedroomAccessAvailable(
    boolean stepFreeBedroomAccessAvailable
  ) {
    this.stepFreeBedroomAccessAvailable = stepFreeBedroomAccessAvailable;
  }

  public boolean isWideBedroomEntranceAvailable() {
    return wideBedroomEntranceAvailable;
  }

  public void setWideBedroomEntranceAvailable(
    boolean wideBedroomEntranceAvailable
  ) {
    this.wideBedroomEntranceAvailable = wideBedroomEntranceAvailable;
  }

  public boolean isStepFreeAccessAvailable() {
    return stepFreeAccessAvailable;
  }

  public void setStepFreeAccessAvailable(boolean stepFreeAccessAvailable) {
    this.stepFreeAccessAvailable = stepFreeAccessAvailable;
  }
}
