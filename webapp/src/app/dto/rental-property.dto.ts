import { AccessibilityDTO } from './accessibility.dto';
import { AmenityDTO } from './amenity.dto';

export class RentalPropertyDTO {
  constructor(
    private id: string,
    private accessibility: AccessibilityDTO,
    private amenity: AmenityDTO,
    private name: string,
    private listed: boolean,
    private pricePerNight: number,
    private beds: number,
    private bedrooms: number,
    private bathrooms: number,
    private street: string,
    private number: string,
    private postalCode: string
  ) {}

  public get getId(): string {
    return this.id;
  }

  public get getAccessibility(): AccessibilityDTO {
    return this.accessibility;
  }

  public set setAccessibility(accessibility: AccessibilityDTO) {
    this.accessibility = accessibility;
  }

  public get getAmenity(): AmenityDTO {
    return this.amenity;
  }

  public set setAmenity(amenity: AmenityDTO) {
    this.amenity = amenity;
  }

  public get getName(): string {
    return this.name;
  }

  public set setName(name: string) {
    this.name = name;
  }

  public get getListed(): boolean {
    return this.listed;
  }

  public set setListed(listed: boolean) {
    this.listed = listed;
  }

  public get getPricePerNight(): number {
    return this.pricePerNight;
  }

  public set setPricePerNight(pricePerNight: number) {
    this.pricePerNight = pricePerNight;
  }

  public get getBeds(): number {
    return this.beds;
  }

  public set setBeds(beds: number) {
    this.beds = beds;
  }

  public get getBedrooms(): number {
    return this.bedrooms;
  }

  public set setBedrooms(bedrooms: number) {
    this.bedrooms = bedrooms;
  }

  public get getBathrooms(): number {
    return this.bathrooms;
  }

  public set setBathrooms(bathrooms: number) {
    this.bathrooms = bathrooms;
  }

  public get getStreet(): string {
    return this.street;
  }

  public set setStreet(street: string) {
    this.street = street;
  }

  public get getNumber(): string {
    return this.number;
  }

  public set setNumber(number: string) {
    this.number = number;
  }

  public get getPostalCode(): string {
    return this.postalCode;
  }

  public set setPostalCode(postalCode: string) {
    this.postalCode = postalCode;
  }
}
