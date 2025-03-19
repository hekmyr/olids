import { Component, inject } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { SidebarComponent } from '../../components/sidebar/sidebar.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';
import { BillingInformation } from '../../interface/billing-information.interface';
import { User } from '../../interface/user.interface';
import { PaymentsComponents } from './components/payments/payments.component';

@Component({
  selector: 'app-account',
  imports: [
    NavBarComponent,
    SidebarComponent,
    ProfileComponent,
    PaymentsComponents
  ],
  template: `
    <div class="min-h-svh flex flex-col">
      <app-nav-bar />
      <div class="flex flex-1">
        <app-sidebar activated="profile" />
        <div class="flex-1 bg-white min-h-full">
          <app-profile [user]="user" />
          <app-payments [billingInformations]="billingInformations" />
        </div>
      </div>
    </div>
  `
})
export class AccountPage {
  private apiService = inject(ApiService);
  public billingInformations: Array<BillingInformation> | null = null;
  public user: User | null = null;
  constructor() {
    firstValueFrom(this.apiService.getAllBillingInformations()).then((data) => {
      this.billingInformations = data;
    });
    firstValueFrom(this.apiService.getUser()).then((data) => {
      this.user = data;
    });
  }
}
