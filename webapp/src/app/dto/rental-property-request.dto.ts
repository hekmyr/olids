export class RentalPropertyRequestDTO {
  constructor(
    public startDate?: Date | null,
    public endDate?: Date | null
  ) {
    startDate = startDate == undefined ? null : startDate;
    endDate = endDate == undefined ? null : endDate;
  }
}
