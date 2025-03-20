import { ReservationDetailInterface } from './reservation-detail.interface';

export interface Reservation {
  id: string;
  details: ReservationDetailInterface[];
}
