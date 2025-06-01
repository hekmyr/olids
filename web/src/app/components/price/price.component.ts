import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-price',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div
      class="inline-block px-[6px] py-[2px] text-white bg-accent-2 rounded-md shadow-md shadow-black/25">
      <span>{{ price() }}€</span>
    </div>
  `
})
export class PriceComponent {
  public price = input.required<number>();
}
