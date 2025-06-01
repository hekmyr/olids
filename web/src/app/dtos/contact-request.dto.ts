export class ContactRequestDTO {
  constructor(
    public email: string,
    public subject: string,
    public message: string
  ) {}
}
