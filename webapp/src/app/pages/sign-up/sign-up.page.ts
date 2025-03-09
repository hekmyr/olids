import { Component } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { SignUpCardComponent } from '../../components/sign/sign-up-card/sign-up-card.component';

@Component({
  selector: 'app-sign-up',
  imports: [NavBarComponent, SignUpCardComponent],
  templateUrl: './sign-up.page.html'
})
export class SignUpPage {}
