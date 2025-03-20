import { BillingInformationCreate } from '../interface/billing-information-create.interface';

export class BillingInformationCreateDTO {
  constructor(
    public cardNumber: string,
    public monthExpiration: number,
    public yearExpiration: number
  ) {}

  public static fromInterface(
    values: BillingInformationCreate
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
