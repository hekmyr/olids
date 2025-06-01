export class UserUpdate {
  constructor(
    public lastName: string,
    public firstName: string,
    public phoneNumber: string,
    public street: string,
    public number: string,
    public postalCode: string,
    public birthDate: Date
  ) {}
}
