import { BillingInformationInterface } from './billing-information.interface';
import { RentalPropertyInterface } from './rental-property.interface';

export interface ReservationInterface {
  id: string;
  pricePerNight: number;
  dateStayStart: Date;
  dateStayEnd: Date;
  isCancelled: boolean;
  guest: number;
  property: RentalPropertyInterface;
  billingInformation: BillingInformationInterface;
}
