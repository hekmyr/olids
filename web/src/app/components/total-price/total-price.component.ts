import { Component } from '@angular/core';
import { input } from '@angular/core';

@Component({
  selector: 'app-total-price',
  standalone: true,
  template: `
    <div class="flex justify-between font-averia">
      <span>Total</span>
      <span>{{ days() }} days x {{ price() }} = {{ total() }} €</span>
    </div>
  `
})
export class TotalPriceComponent {
  public days = input<number>(0);
  public price = input.required<number>();

  public total(): number {
    return this.days() * this.price();
  }
}
