import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { NavBarLogoComponent } from './nav-bar-logo/nav-bar-logo.component';
import { NavBarOptionComponent } from './nav-bar-option/nav-bar-option.component';
import { APP_NAME } from '../../constant';
import { NavBarLinkComponent } from './nav-bar-link/nav-bar-link.component';

@Component({
  selector: 'app-nav-bar',
  imports: [NavBarLogoComponent, NavBarLinkComponent, NavBarOptionComponent],
  template: `
    <div class="bg-[#F0EFEB] flex justify-between px-12 py-3">
      <div class="flex gap-12">
        <nav-bar-logo text="{{ appName }}" link="/" />
        <div class="flex gap-6">
          <nav-bar-link text="À propos" link="/about" />
          <nav-bar-link text="Contact" link="/contact" />
          <nav-bar-link text="FAQ" link="/faq" />
        </div>
      </div>
      <div class="flex gap-6">
        <nav-bar-link text="Tableau de bord" link="/account" />
        <nav-bar-link text="Mes réservations" link="/reservations" />
        <nav-bar-option text="Deconnexion" />
      </div>
    </div>
  `
})
export class NavBarComponent {
  appName = APP_NAME;
}
