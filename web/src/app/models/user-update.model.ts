export class UserUpdateModel {
  constructor(
    private _lastName: string | null,
    private _firstName: string | null,
    private _phoneNumber: string | null,
    private _street: string | null,
    private _number: string | null,
    private _postalCode: string | null,
    private _birthDate: Date | null
  ) {}

  public get lastName(): string | null {
    return this._lastName;
  }

  public set lastName(value: string | null) {
    this._lastName = value;
  }

  public get firstName(): string | null {
    return this._firstName;
  }

  public set firstName(value: string | null) {
    this._firstName = value;
  }

  public get phoneNumber(): string | null {
    return this._phoneNumber;
  }

  public set phoneNumber(value: string | null) {
    this._phoneNumber = value;
  }

  public get street(): string | null {
    return this._street;
  }

  public set street(value: string | null) {
    this._street = value;
  }

  public get number(): string | null {
    return this._number;
  }

  public set number(value: string | null) {
    this._number = value;
  }

  public get postalCode(): string | null {
    return this._postalCode;
  }

  public set postalCode(value: string | null) {
    this._postalCode = value;
  }

  public get birthDate(): Date | null {
    return this._birthDate;
  }

  public set birthDate(value: Date | null) {
    this._birthDate = value;
  }
}
