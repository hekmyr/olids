import { Component, input, output } from '@angular/core';
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
        <div class="grid grid-cols-4 gap-12">
          @for (bi of billingInformations(); track $index) {
            @let cardType = recognizeCardType(bi);
            @if (cardType !== null) {
              <app-credit-card
                [card]="bi"
                [cardType]="cardType"
                (onChange)="onChange.emit()" />
            }
          }
          <app-credit-card type="create-plus" (onChange)="onChange.emit()" />
        </div>
      } @else {
        Loading...
      }
    </div>
  `
})
export class PaymentsComponents {
  public billingInformations =
    input.required<Array<BillingInformation> | null>();
  public onChange = output<void>();

  public recognizeCardType(bi: BillingInformation): string | null {
    let cardType: string | null = null;
    const cleanedNumber = bi.cardNumber.replace(/\D/g, '');
    if (/^4/.test(cleanedNumber)) {
      cardType = 'Visa';
    } else if (/^5[1-5]/.test(cleanedNumber)) {
      cardType = 'MasterCard';
    } else if (/^3[47]/.test(cleanedNumber)) {
      cardType = 'American Express';
    } else if (/^(6703|489999|490303|676[0-9])/.test(cleanedNumber)) {
      cardType = 'Bancontact';
    } else {
      cardType = null;
    }

    return cardType;
  }
}
