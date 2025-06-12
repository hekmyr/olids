export interface RentalPropertyInterface {
  id: string;
  name: string;
  description: string;
  listed: boolean;
  list_price: number;
  beds: number;
  bedrooms: number;
  bathrooms: number;
  street: string;
  number: string;
  postalCode: string;
  image_1920?: string;
  max_guests: number;

  // Amenities
  air_conditioning_available: boolean;
  terrace_available: boolean;
  garden_available: boolean;
  pool_available: boolean;
  hot_tub_available: boolean;
  ev_charger_available: boolean;
  indoor_fireplace_available: boolean;
  outdoor_fireplace_available: boolean;
  dedicated_workspace_available: boolean;
  gym_available: boolean;

  // Accessibilities
  toilet_grab_bar_available: boolean;
  shower_grab_bar_available: boolean;
  step_free_shower_available: boolean;
  shower_bath_chair_available: boolean;
  step_free_bedroom_access_available: boolean;
  wide_bedroom_entrance_available: boolean;
  step_free_access_available: boolean;
}
