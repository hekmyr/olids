export class BillingInformationCreateDTO {
  constructor(
    public cardNumber: string,
    public monthExpiration: number,
    public yearExpiration: number
  ) {}
}
