import { ReservationDetailModel } from './reservation-detail.model';

export class ReservationModel {
  private _id: string;
  private _details: ReservationDetailModel[];

  constructor(id: string, details: ReservationDetailModel[]) {
    this._id = id;
    this._details = details;
  }

  public get id(): string {
    return this._id;
  }

  public set id(value: string) {
    this._id = value;
  }

  public get details(): ReservationDetailModel[] {
    return this._details;
  }

  public set details(value: ReservationDetailModel[]) {
    this._details = value;
  }
}
