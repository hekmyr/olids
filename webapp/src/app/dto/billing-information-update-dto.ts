export class BillingInformationUpdateDTO {
  constructor(
    public id: string,
    public cardNumber: string,
    public monthExpiration: number,
    public yearExpiration: number
  ) {}
}
