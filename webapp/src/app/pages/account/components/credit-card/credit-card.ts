import { Component, input } from '@angular/core';
import {
  CreditCardIcon,
  LucideAngularModule,
  Trash2Icon
} from 'lucide-angular';
import { BillingInformation } from '../../../../interface/billing-information.interface';
@Component({
  selector: 'app-credit-card',
  imports: [LucideAngularModule],
  template: `
    <div class="border-[#9A9BA1] bg-[#CFD0D4] bg-opacity-50 p-8">
      <span>{{ cardType }}</span>
      <lucide-angular [img]="creditCardIcon"></lucide-angular>
      <span>{{ card().cardNumber }}</span>
      <span>{{ card().monthExpiration }}/{{ card().yearExpiration }}</span>
      <div class="bg-[CFD0D4] rounded-lg">Choisir primaire</div>
    </div>
  `
})
export class CreditCardComponent {
  public card = input.required<BillingInformation>();
  public cardType: string | null = null;
  public creditCardIcon = CreditCardIcon;
  public rubishIcon = Trash2Icon;
}
