export class SignInDTO {
  constructor();
  constructor(
    public email?: string,
    public password?: string
  ) {
    this.email = email || '';
    this.password = password || '';
  }
}
