import { BillingInformationUpdateInterface } from '../interfaces/billing-information-update.interface';

export class BillingInformationUpdateDTO {
  constructor(
    public id: string,
    public cardNumber: string,
    public monthExpiration: number,
    public yearExpiration: number
  ) {}

  public static fromInterface(
    values: BillingInformationUpdateInterface
  ): BillingInformationUpdateDTO {
    const yearValue = Number(values.yearExpiration);
    const fullYear = yearValue < 100 ? 2000 + yearValue : yearValue;

    return new BillingInformationUpdateDTO(
      values.id ?? '',
      values.cardNumber ?? '',
      Number(values.monthExpiration),
      fullYear
    );
  }
}
