import { Reservation } from '../interfaces/reservation.interface';
import { ReservationDetailModel } from '../models/reservation-detail.model';
import { ReservationModel } from '../models/reservation.model';

export class ReservationCreateDTO {
  constructor(
    public propertyId: string,
    public stayStart: Date,
    public stayEnd: Date
  ) {}
}
