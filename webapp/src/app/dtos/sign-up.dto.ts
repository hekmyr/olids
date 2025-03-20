export class SignUpDTO {
  constructor();
  constructor(
    public email?: string,
    public password?: string
  ) {
    this.email = email || '';
    this.password = password || '';
  }

  public set setPassword(value: string) {
    this.password = value;
  }
}
