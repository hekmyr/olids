import { AccessibilityDTO } from './accessibility.dto';
import { AmenityDTO } from './amenity.dto';

export class RentalPropertyDTO {
  constructor(
    private _id: string,
    private _accessibility: AccessibilityDTO,
    private _amenity: AmenityDTO,
    private _name: string,
    private _description: string,
    private _listed: boolean,
    private _pricePerNight: number,
    private _beds: number,
    private _bedrooms: number,
    private _bathrooms: number,
    private _street: string,
    private _number: string,
    private _postalCode: string
  ) {}

  public get id(): string {
    return this._id;
  }

  public get accessibility(): AccessibilityDTO {
    return this._accessibility;
  }

  public set accessibility(accessibility: AccessibilityDTO) {
    this._accessibility = accessibility;
  }

  public get amenity(): AmenityDTO {
    return this._amenity;
  }

  public set amenity(amenity: AmenityDTO) {
    this._amenity = amenity;
  }

  public get name(): string {
    return this._name;
  }

  public set name(name: string) {
    this._name = name;
  }

  public get description(): string {
    return this._description;
  }

  public set description(description: string) {
    this._description = description;
  }

  public get listed(): boolean {
    return this._listed;
  }

  public set listed(listed: boolean) {
    this._listed = listed;
  }

  public get pricePerNight(): number {
    return this._pricePerNight;
  }

  public set pricePerNight(pricePerNight: number) {
    this._pricePerNight = pricePerNight;
  }

  public get beds(): number {
    return this._beds;
  }

  public set beds(beds: number) {
    this._beds = beds;
  }

  public get bedrooms(): number {
    return this._bedrooms;
  }

  public set bedrooms(bedrooms: number) {
    this._bedrooms = bedrooms;
  }

  public get bathrooms(): number {
    return this._bathrooms;
  }

  public set bathrooms(bathrooms: number) {
    this._bathrooms = bathrooms;
  }

  public get street(): string {
    return this._street;
  }

  public set street(street: string) {
    this._street = street;
  }

  public get number(): string {
    return this._number;
  }

  public set number(number: string) {
    this._number = number;
  }

  public get postalCode(): string {
    return this._postalCode;
  }

  public set postalCode(postalCode: string) {
    this._postalCode = postalCode;
  }
}
