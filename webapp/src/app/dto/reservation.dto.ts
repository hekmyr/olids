import { ReservationDetailDTO } from './reservation-detail.dto';

export class ReservationDTO {
  private _id: string;
  private _details: ReservationDetailDTO[];

  constructor(id: string, details: ReservationDetailDTO[]) {
    this._id = id;
    this._details = details;
  }

  public get id(): string {
    return this._id;
  }

  public set id(value: string) {
    this._id = value;
  }

  public get details(): ReservationDetailDTO[] {
    return this._details;
  }

  public set details(value: ReservationDetailDTO[]) {
    this._details = value;
  }
}
