import { BillingInformationCreateInterface } from '../interfaces/billing-information-create.interface';

export class BillingInformationCreateDTO {
  constructor(
    public cardNumber: string,
    public monthExpiration: number,
    public yearExpiration: number
  ) {}

  public static fromInterface(
    values: BillingInformationCreateInterface
  ): BillingInformationCreateDTO {
    const yearValue = Number(values.yearExpiration);
    const fullYear = yearValue < 100 ? 2000 + yearValue : yearValue;

    return new BillingInformationCreateDTO(
      values.cardNumber ?? '',
      Number(values.monthExpiration),
      fullYear
    );
  }
}
