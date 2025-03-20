import { User } from '../interfaces/user.interface';

export class UserModel {
  constructor(
    private _lastName: string,
    private _firstName: string,
    private _email: string,
    private _phoneNumber: string,
    private _street: string,
    private _number: string,
    private _postalCode: string,
    private _birthDate: Date
  ) {}

  public get lastName(): string {
    return this._lastName;
  }

  public set lastName(value: string) {
    this._lastName = value;
  }

  public get firstName(): string {
    return this._firstName;
  }

  public set firstName(value: string) {
    this._firstName = value;
  }

  public get email(): string {
    return this._email;
  }

  public set email(value: string) {
    this._email = value;
  }

  public get phoneNumber(): string {
    return this._phoneNumber;
  }

  public set phoneNumber(value: string) {
    this._phoneNumber = value;
  }

  public get street(): string {
    return this._street;
  }

  public set street(value: string) {
    this._street = value;
  }

  public get number(): string {
    return this._number;
  }

  public set number(value: string) {
    this._number = value;
  }

  public get postalCode(): string {
    return this._postalCode;
  }

  public set postalCode(value: string) {
    this._postalCode = value;
  }

  public get birthDate(): Date {
    return this._birthDate;
  }

  public set birthDate(value: Date) {
    this._birthDate = value;
  }

  public static fromInterface(user: User): UserModel {
    return new UserModel(
      user.lastName,
      user.firstName,
      user.email,
      user.phoneNumber,
      user.street,
      user.number,
      user.postalCode,
      user.birthDate
    );
  }
}
