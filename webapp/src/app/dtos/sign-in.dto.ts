export class SignInDTO {
  private email: string;
  private password: string;

  constructor();
  constructor(email?: string, password?: string) {
    this.email = email || '';
    this.password = password || '';
  }

  public get getEmail(): string {
    return this.email;
  }

  public set setEmail(value: string) {
    this.email = value;
  }

  public get getPassword(): string {
    return this.password;
  }

  public set setPassword(value: string) {
    this.password = value;
  }
}
