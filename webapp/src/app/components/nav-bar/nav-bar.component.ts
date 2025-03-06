import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NavBarLogoComponent } from './nav-bar-logo/nav-bar-logo.component';
import { NavBarOptionComponent } from './nav-bar-option/nav-bar-option.component';
import { APP_NAME } from '../../constant';
import { NavBarLinkComponent } from './nav-bar-link/nav-bar-link.component';

@Component({
  selector: 'app-nav-bar',
  imports: [NavBarLogoComponent, NavBarLinkComponent, NavBarOptionComponent],
  templateUrl: './nav-bar.component.html'
})
export class NavBarComponent {
  appName = APP_NAME;
}
