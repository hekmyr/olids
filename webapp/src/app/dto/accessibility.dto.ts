export class AccessibilityDTO {
  id: string;
  toiletGrabBarAvailable: boolean;
  showerGrabBarAvailable: boolean;
  stepFreeShowerAvailable: boolean;
  showerBathChairAvailable: boolean;
  stepFreeBedroomAccessAvailable: boolean;
  wideBedroomEntranceAvailable: boolean;
  stepFreeAccessAvailable: boolean;

  constructor(
    id: string,
    toiletGrabBarAvailable: boolean,
    showerGrabBarAvailable: boolean,
    stepFreeShowerAvailable: boolean,
    showerBathChairAvailable: boolean,
    stepFreeBedroomAccessAvailable: boolean,
    wideBedroomEntranceAvailable: boolean,
    stepFreeAccessAvailable: boolean
  ) {
    this.id = id;
    this.toiletGrabBarAvailable = toiletGrabBarAvailable;
    this.showerGrabBarAvailable = showerGrabBarAvailable;
    this.stepFreeShowerAvailable = stepFreeShowerAvailable;
    this.showerBathChairAvailable = showerBathChairAvailable;
    this.stepFreeBedroomAccessAvailable = stepFreeBedroomAccessAvailable;
    this.wideBedroomEntranceAvailable = wideBedroomEntranceAvailable;
    this.stepFreeAccessAvailable = stepFreeAccessAvailable;
  }
}
