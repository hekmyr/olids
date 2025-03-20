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
        <div class="flex flex-col flex-1 bg-white min-h-full px-8 py-4 gap-8">
          <app-profile [user]="user" />
          <app-payments
            [billingInformations]="billingInformations"
            (onChange)="loadBillingInformation()" />
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

    this.loadBillingInformation();
  }

  public loadBillingInformation() {
    const dummyCards: BillingInformation[] = [
      {
        id: 'visa1',
        cardNumber: '4111111111111111',
        monthExpiration: 6,
        yearExpiration: 25,
        isDefault: false
      },
      {
        id: 'mc1',
        cardNumber: '5555555555554444',
        monthExpiration: 8,
        yearExpiration: 28,
        isDefault: true
      },
      {
        id: 'amex1',
        cardNumber: '378282246310005',
        monthExpiration: 12,
        yearExpiration: 24,
        isDefault: false
      },
      {
        id: 'bancontact1',
        cardNumber: '6703123456789012',
        monthExpiration: 3,
        yearExpiration: 27,
        isDefault: false
      },
      {
        id: 'bancontact2',
        cardNumber: '4899991234567890',
        monthExpiration: 5,
        yearExpiration: 25,
        isDefault: false
      },
      {
        id: 'discover1',
        cardNumber: '6011000990139424',
        monthExpiration: 9,
        yearExpiration: 28,
        isDefault: false
      }
    ];

    this.billingInformations = dummyCards;
  }
}
