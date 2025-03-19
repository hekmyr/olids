import { Component, input } from '@angular/core';
import { BillingInformation } from '../../../../interface/billing-information.interface';
import { CreditCardComponent } from '../credit-card/credit-card';
@Component({
  selector: 'app-payments',
  imports: [CreditCardComponent],
  template: `
    <div class="flex flex-col gap-3">
      <h3 class="text-2xl font-[Averia_Serif_Libre] font-bold">
        Informations de payment
      </h3>
      @if (billingInformations() !== null) {
        @for (bi of billingInformations(); track $index) {
          <app-credit-card [card]="bi" />
        }
      }
    </div>
  `
})
export class PaymentsComponents {
  public billingInformations =
    input.required<Array<BillingInformation> | null>();
}
