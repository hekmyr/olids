import { User } from '../interfaces/user.interface';

export class UserModel {
  constructor(
    public name: string,
    public phone: string,
    public street: string,
    public zip: string
  ) { }
}
