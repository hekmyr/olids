import { RentalPropertyInterface } from '../interfaces/rental-property.interface';
import { AccessibilityModel } from './accessibility.model';
import { AmenityModel } from './amenity.model';

export class RentalPropertyModel {
  constructor(
    private _id: string,
    private _accessibility: AccessibilityModel,
    private _amenity: AmenityModel,
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

  public get accessibility(): AccessibilityModel {
    return this._accessibility;
  }

  public set accessibility(accessibility: AccessibilityModel) {
    this._accessibility = accessibility;
  }

  public get amenity(): AmenityModel {
    return this._amenity;
  }

  public set amenity(amenity: AmenityModel) {
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
  public static fromInterface(
    property: RentalPropertyInterface
  ): RentalPropertyModel {
    return new RentalPropertyModel(
      property.id,
      AccessibilityModel.fromInterface(property.accessibility),
      AmenityModel.fromInterface(property.amenity),
      property.name,
      property.description || '',
      property.listed,
      property.pricePerNight,
      property.beds,
      property.bedrooms,
      property.bathrooms,
      property.street,
      property.number,
      property.postalCode
    );
  }
}
