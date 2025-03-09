import { Component } from '@angular/core';
import { SignInCardComponent } from '../../components/sign/sign-in-card/sign-in-card.component';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';

@Component({
  selector: 'app-sign-in',
  imports: [NavBarComponent, SignInCardComponent],
  templateUrl: './sign-in.page.html'
})
export class SignInPage {}
