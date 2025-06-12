export class ReservationCreateDTO {
  constructor(
    public propertyId: string,
    public dateStayBegin: Date,
    public dateStayEnd: Date,
    public guests: number
  ) { }
}
