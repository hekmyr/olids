export class RentalPropertyRequestDTO {
  constructor(
    private _startDate?: Date | null,
    private _endDate?: Date | null
  ) {
    _startDate = _startDate == undefined ? null : _startDate;
    _endDate = _endDate == undefined ? null : _endDate;
  }
  public get startDate(): Date | undefined | null {
    return this._startDate;
  }

  public set startDate(value: Date) {
    this._startDate = value;
  }

  public get endDate(): Date | undefined | null {
    return this._endDate;
  }

  set endDate(value: Date) {
    this._endDate = value;
  }
}
