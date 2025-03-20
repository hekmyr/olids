import { ReservationDetail } from '../interface/reservation-detail.interface';

export class ReservationDetailDTO {
  constructor(
    private _id: string,
    private _pricePerNight: number,
    private _dateStayStart: Date,
    private _dateStayEnd: Date,
    private _isCancelled: boolean
  ) {}

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

  public get isCancelled(): boolean {
    return this._isCancelled;
  }

  public set isCancelled(value: boolean) {
    this._isCancelled = value;
  }

  public static fromInterface(
    reservationDetail: ReservationDetail
  ): ReservationDetailDTO {
    return new ReservationDetailDTO(
      reservationDetail.id,
      reservationDetail.pricePerNight,
      reservationDetail.dateStayStart,
      reservationDetail.dateStayEnd,
      reservationDetail.isCancelled
    );
  }
}
