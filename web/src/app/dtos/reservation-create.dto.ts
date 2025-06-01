export class ReservationCreateDTO {
  constructor(
    public propertyId: string,
    public stayStart: Date,
    public stayEnd: Date,
    public guests: number
  ) {}
}
