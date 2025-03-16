import { ReservationDetail } from './reservation-detail.interface';

export interface Reservation {
  id: string;
  details: ReservationDetail[];
}
