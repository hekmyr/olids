import { Component, inject, OnChanges, OnDestroy, OnInit } from '@angular/core';
import { NavBarLogoComponent } from './nav-bar-logo/nav-bar-logo.component';
import { NavBarOptionComponent } from './nav-bar-option/nav-bar-option.component';
import { APP_NAME } from '../../constant';
import { NavBarLinkComponent } from './nav-bar-link/nav-bar-link.component';
import { AuthService } from '../../services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-nav-bar',
  imports: [NavBarLogoComponent, NavBarLinkComponent, NavBarOptionComponent],
  template: `
    <div class="bg-[#F0EFEB] flex justify-between px-4 py-3">
      <div class="flex gap-12">
        <nav-bar-logo text="{{ appName }}" link="/" />
        <div class="flex gap-6">
          <nav-bar-link text="À propos" link="/about" />
          <nav-bar-link text="Contact" link="/contact" />
          <nav-bar-link text="FAQ" link="/faq" />
        </div>
      </div>
      <div class="flex gap-6">
        @if (isAuthenticated) {
          <nav-bar-link text="Tableau de bord" link="/dashboard/profile" />
          <nav-bar-link
            text="Mes réservations"
            link="/dashboard/reservations" />
          <nav-bar-option text="Deconnexion" />
        } @else {
          <nav-bar-option text="Se connecter" link="/sign-in" />
        }
      </div>
    </div>
  `
})
export class NavBarComponent implements OnInit, OnDestroy {
  appName = APP_NAME;
  private authSub: Subscription | null = null;

  ngOnInit(): void {
    this.isAuthenticated = this.authService.getIsAuthenticated();

    this.authSub = this.authService.authState$.subscribe((state) => {
      this.isAuthenticated = state;
    });
  }

  ngOnDestroy(): void {
    if (this.authSub) {
      this.authSub.unsubscribe();
    }
  }

  authService = inject(AuthService);
  isAuthenticated = this.authService.getIsAuthenticated();
}
