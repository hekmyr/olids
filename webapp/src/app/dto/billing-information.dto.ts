import { BillingInformation } from '../interface/billing-information.interface';

export class BillingInformationDTO {
  constructor(
    private _id: string,
    private _cardNumber: string,
    private _monthExpiration: number,
    private _yearExpiration: number
  ) {}

  public get id(): string {
    return this._id;
  }

  public get cardNumber(): string {
    return this._cardNumber;
  }

  public set cardNumber(value: string) {
    this._cardNumber = value;
  }

  public get monthExpiration(): number {
    return this._monthExpiration;
  }

  public set monthExpiration(value: number) {
    this._monthExpiration = value;
  }

  public get yearExpiration(): number {
    return this._yearExpiration;
  }

  public set yearExpiration(value: number) {
    this._yearExpiration = value;
  }

  public static fromInterface(
    billingInformation: BillingInformation
  ): BillingInformationDTO {
    return new BillingInformationDTO(
      billingInformation.id,
      billingInformation.cardNumber,
      billingInformation.monthExpiration,
      billingInformation.yearExpiration
    );
  }
}
