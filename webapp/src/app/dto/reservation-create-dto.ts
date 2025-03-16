import { Reservation } from '../interface/reservation.interface';
import { ReservationDetailDTO } from './reservation-detail.dto';
import { ReservationDTO } from './reservation.dto';

export class ReservationCreateDTO {
  constructor(
    public propertyId: string,
    public stayStart: Date,
    public stayEnd: Date
  ) {}
}
