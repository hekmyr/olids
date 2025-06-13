import { BillingInformationInterface } from './billing-information.interface';
import { RentalPropertyInterface } from './rental-property.interface';

export interface ReservationInterface {
  id: string;
  productId: [number, string];
  name: string;
  priceTotal: number;
  dateStayBegin: string;
  dateStayEnd: string;
}
