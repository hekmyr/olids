import { BillingInformation } from './billing-information.interface';
import { RentalProperty } from './rental-property.interface';

export interface ReservationDetail {
  id: string;
  pricePerNight: number;
  dateStayStart: Date;
  dateStayEnd: Date;
  isCancelled: boolean;
  guest: number;
  property: RentalProperty;
  billingInformation: BillingInformation;
}
