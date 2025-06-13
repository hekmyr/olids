export class UserUpdateDTO {
  constructor(
    public name: string,
    public phone: string | null,
    public street: string | null,
    public zip: string | null
  ) { }
}
