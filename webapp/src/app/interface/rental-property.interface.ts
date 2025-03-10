import { Accessibility } from "./accessibility.interface";
import { Amenity } from "./amenity.interface";

export interface RentalProperty {
  id: string;
  accessibility: Accessibility;
  amenity: Amenity;
  name: string;
  listed: boolean;
  pricePerNight: number;
  beds: number;
  bedrooms: number;
  bathrooms: number;
  street: string;
  number: string;
  postalCode: string;
}
