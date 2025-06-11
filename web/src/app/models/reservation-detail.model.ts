import { ReservationDetailInterface } from '../interfaces/reservation-detail.interface';

export class ReservationDetailModel {
  constructor(
    private _id: string,
    private _list_price: number,
    private _dateStayStart: Date,
    private _dateStayEnd: Date,
    private _isCancelled: boolean
  ) { }

  public get id(): string {
    return this._id;
  }

  public set id(value: string) {
    this._id = value;
  }

  public get list_price(): number {
    return this._list_price;
  }

  public set list_price(value: number) {
    this._list_price = value;
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
    reservationDetail: ReservationDetailInterface
  ): ReservationDetailModel {
    return new ReservationDetailModel(
      reservationDetail.id,
      reservationDetail.list_price,
      reservationDetail.dateStayStart,
      reservationDetail.dateStayEnd,
      reservationDetail.isCancelled
    );
  }
}
