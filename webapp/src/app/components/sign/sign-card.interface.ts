import { SignInDTO } from '../../dtos/sign-in.dto';
import { SignUpDTO } from '../../dtos/sign-up.dto';
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
