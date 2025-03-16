import { ReservationDetail } from '../interface/reservation-detail.interface';

export class ReservationDetailDTO {
  private _id: string;
  private _pricePerNight: number;
  private _dateStayStart: Date;
  private _dateStayEnd: Date;

  constructor(
    id: string,
    pricePerNight: number,
    dateStayStart: Date,
    dateStayEnd: Date
  ) {
    this._id = id;
    this._pricePerNight = pricePerNight;
    this._dateStayStart = dateStayStart;
    this._dateStayEnd = dateStayEnd;
  }

  public get id(): string {
    return this._id;
  }

  public set id(value: string) {
    this._id = value;
  }

  public get pricePerNight(): number {
    return this._pricePerNight;
  }

  public set pricePerNight(value: number) {
    this._pricePerNight = value;
  }

  public get dateStayStart(): Date {
    return this._dateStayStart;
  }

  public set dateStayStart(value: Date) {
    this._dateStayStart = value;
  }

  public get dateStayEnd(): Date {
    return this._dateStayEnd;
  }

  public set dateStayEnd(value: Date) {
    this._dateStayEnd = value;
  }

  public static fromInterface(
    reservationDetail: ReservationDetail
  ): ReservationDetailDTO {
    return new ReservationDetailDTO(
      reservationDetail.id,
      reservationDetail.pricePerNight,
      reservationDetail.dateStayStart,
      reservationDetail.dateStayEnd
    );
  }
}
