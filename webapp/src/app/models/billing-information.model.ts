import { BillingInformationInterface } from '../interfaces/billing-information.interface';

export class BillingInformationInterfaceModel {
  constructor(
    private _id: string,
    private _cardNumber: string,
    private _monthExpiration: number,
    private _yearExpiration: number,
    private _ccv: string | null
  ) {
    this._ccv = '';
  }

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

  public get ccv(): string | null {
    return this._ccv;
  }

  public set ccv(value: string | null) {
    this._ccv = value;
  }

  public static fromInterface(
    BillingInformationInterface: BillingInformationInterface
  ): BillingInformationInterfaceModel {
    return new BillingInformationInterfaceModel(
      billingInformation.id,
      billingInformation.cardNumber,
      billingInformation.monthExpiration,
      billingInformation.yearExpiration,
      null
    );
  }
}
