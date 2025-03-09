import { SignInDTO } from '../../dto/sign-in-dto';
import { SignUpDTO } from '../../dto/sign-up-dto';
import { Link } from './link.interface';

export interface SignCardComponent {
  title: string;
  link: Link;
  buttonText: string;
  imageUrl: string;
  setEmail(value: string): void;
  setPassword(value: string): void;
  submit(): void;
}
