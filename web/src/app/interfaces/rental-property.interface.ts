import { AccessibilityInterface } from './accessibility.interface';
import { AmenityInterface } from './amenity.interface';

export interface RentalPropertyInterface {
  id: string;
  accessibility: AccessibilityInterface;
  amenity: AmenityInterface;
  name: string;
  description: string;
  listed: boolean;
  pricePerNight: number;
  beds: number;
  bedrooms: number;
  bathrooms: number;
  street: string;
  number: string;
  postalCode: string;
  image: string;
  maxGuests: number;
}
