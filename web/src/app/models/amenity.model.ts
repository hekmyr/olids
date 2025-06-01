import { AmenityInterface } from '../interfaces/amenity.interface';

export class AmenityModel {
  constructor(
    private _id: string,
    private _airConditioningAvailable: boolean,
    private _terraceAvailable: boolean,
    private _gardenAvailable: boolean,
    private _poolAvailable: boolean,
    private _hotTubAvailable: boolean,
    private _evChargerAvailable: boolean,
    private _indoorFireplaceAvailable: boolean,
    private _outdoorFireplaceAvailable: boolean,
    private _dedicatedWorkspaceAvailable: boolean,
    private _gymAvailable: boolean
  ) {}

  public get id(): string {
    return this._id;
  }
  public get airConditioningAvailable(): boolean {
    return this._airConditioningAvailable;
  }
  public set airConditioningAvailable(value: boolean) {
    this._airConditioningAvailable = value;
  }
  public get terraceAvailable(): boolean {
    return this._terraceAvailable;
  }
  public set terraceAvailable(value: boolean) {
    this._terraceAvailable = value;
  }
  public get gardenAvailable(): boolean {
    return this._gardenAvailable;
  }
  public set gardenAvailable(value: boolean) {
    this._gardenAvailable = value;
  }
  public get poolAvailable(): boolean {
    return this._poolAvailable;
  }
  public set poolAvailable(value: boolean) {
    this._poolAvailable = value;
  }
  public get hotTubAvailable(): boolean {
    return this._hotTubAvailable;
  }
  public set hotTubAvailable(value: boolean) {
    this._hotTubAvailable = value;
  }
  public get evChargerAvailable(): boolean {
    return this._evChargerAvailable;
  }
  public set evChargerAvailable(value: boolean) {
    this.evChargerAvailable = value;
  }
  public get indoorFireplaceAvailable(): boolean {
    return this._indoorFireplaceAvailable;
  }
  public set indoorFireplaceAvailable(value: boolean) {
    this._indoorFireplaceAvailable = value;
  }
  public get outdoorFireplaceAvailable(): boolean {
    return this._outdoorFireplaceAvailable;
  }
  public set outdoorFireplaceAvailable(value: boolean) {
    this._outdoorFireplaceAvailable = value;
  }
  public get dedicatedWorkspaceAvailable(): boolean {
    return this._dedicatedWorkspaceAvailable;
  }
  public set dedicatedWorkspaceAvailable(value: boolean) {
    this.dedicatedWorkspaceAvailable = value;
  }
  public get gymAvailable(): boolean {
    return this.gymAvailable;
  }
  public set gymAvailable(value: boolean) {
    this._gymAvailable = value;
  }

  public static fromInterface(amenity: AmenityInterface): AmenityModel {
    return new AmenityModel(
      amenity.id,
      amenity.airConditioningAvailable,
      amenity.terraceAvailable,
      amenity.gardenAvailable,
      amenity.poolAvailable,
      amenity.hotTubAvailable,
      amenity.evChargerAvailable,
      amenity.indoorFireplaceAvailable,
      amenity.outdoorFireplaceAvailable,
      amenity.dedicatedWorkspaceAvailable,
      amenity.gymAvailable
    );
  }
}
