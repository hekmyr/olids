import { Accessibility } from '../interface/accessibility.interface';

export class AccessibilityDTO {
  constructor(
    private _id: string,
    private _toiletGrabBarAvailable: boolean,
    private _showerGrabBarAvailable: boolean,
    private _stepFreeShowerAvailable: boolean,
    private _showerBathChairAvailable: boolean,
    private _stepFreeBedroomAccessAvailable: boolean,
    private _wideBedroomEntranceAvailable: boolean,
    private _stepFreeAccessAvailable: boolean
  ) {}

  public get id(): string {
    return this._id;
  }

  public set id(id: string) {
    this._id = id;
  }

  public get toiletGrabBarAvailable(): boolean {
    return this._toiletGrabBarAvailable;
  }

  public set toiletGrabBarAvailable(toiletGrabBarAvailable: boolean) {
    this._toiletGrabBarAvailable = toiletGrabBarAvailable;
  }

  public get showerGrabBarAvailable(): boolean {
    return this._showerGrabBarAvailable;
  }

  public set showerGrabBarAvailable(showerGrabBarAvailable: boolean) {
    this._showerGrabBarAvailable = showerGrabBarAvailable;
  }

  public get stepFreeShowerAvailable(): boolean {
    return this._stepFreeShowerAvailable;
  }

  public set stepFreeShowerAvailable(stepFreeShowerAvailable: boolean) {
    this._stepFreeShowerAvailable = stepFreeShowerAvailable;
  }

  public get showerBathChairAvailable(): boolean {
    return this._showerBathChairAvailable;
  }

  public set showerBathChairAvailable(showerBathChairAvailable: boolean) {
    this._showerBathChairAvailable = showerBathChairAvailable;
  }

  public get stepFreeBedroomAccessAvailable(): boolean {
    return this._stepFreeBedroomAccessAvailable;
  }

  public set stepFreeBedroomAccessAvailable(
    stepFreeBedroomAccessAvailable: boolean
  ) {
    this._stepFreeBedroomAccessAvailable = stepFreeBedroomAccessAvailable;
  }

  public get wideBedroomEntranceAvailable(): boolean {
    return this._wideBedroomEntranceAvailable;
  }

  public set wideBedroomEntranceAvailable(
    wideBedroomEntranceAvailable: boolean
  ) {
    this._wideBedroomEntranceAvailable = wideBedroomEntranceAvailable;
  }

  public get stepFreeAccessAvailable(): boolean {
    return this._stepFreeAccessAvailable;
  }

  public set stepFreeAccessAvailable(stepFreeAccessAvailable: boolean) {
    this._stepFreeAccessAvailable = stepFreeAccessAvailable;
  }

  public static fromInterface(accessibility: Accessibility): AccessibilityDTO {
    return new AccessibilityDTO(
      accessibility.id,
      accessibility.toiletGrabBarAvailable,
      accessibility.showerGrabBarAvailable,
      accessibility.stepFreeShowerAvailable,
      accessibility.showerBathChairAvailable,
      accessibility.stepFreeBedroomAccessAvailable,
      accessibility.wideBedroomEntranceAvailable,
      accessibility.stepFreeAccessAvailable
    );
  }
}
