import { BillingInformationInterface } from './billing-information.interface';
import { RentalPropertyInterface } from './rental-property.interface';

export interface ReservationInterface {
  id: string;
  list_price: number;
  dateStayStart: Date;
  dateStayEnd: Date;
  isCancelled: boolean;
  isPayed: boolean;
  guest: number;
  property: RentalPropertyInterface;
  billingInformation: BillingInformationInterface;
}
