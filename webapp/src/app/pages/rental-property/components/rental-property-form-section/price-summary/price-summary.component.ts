import { Component, input } from '@angular/core';
import { RentalPropertyModel } from '../../../../../models/rental-property.model';

@Component({
  selector: 'app-price-summary',
  standalone: true,
  template: `
    <div class="flex flex-col gap-2">
      <div class="flex justify-between">
        <span> Coût du séjour </span>
        <span
          >{{ numberOfNights() }} x {{ property().pricePerNight }}
          {{ currency() }}</span
        >
      </div>
      <div class="flex justify-between">
        <span>Total</span>
        <span>{{ totalCost() }} {{ currency() }}</span>
      </div>
    </div>
  `
})
export class PriceSummaryComponent {
  property = input.required<RentalPropertyModel>();
  numberOfNights = input.required<number>();
  totalCost = input.required<number>();
  currency = input.required<string>();
}
