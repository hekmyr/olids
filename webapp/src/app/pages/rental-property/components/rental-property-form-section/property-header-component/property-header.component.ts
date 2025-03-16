import { Component, input } from '@angular/core';
import { RentalPropertyDTO } from '../../../../../dto/rental-property.dto';

@Component({
  selector: 'app-property-header',
  standalone: true,
  template: `
    <div class="flex flex-col gap-2">
      <h1 class="text-7xl font-[Averia_Serif_Libre] font-bold">
        {{ property().name }}
      </h1>
      <div class="flex gap-2">
        <div class="inline-flex gap-x-2">
          <span class="text-xl">Lits</span>
          <span class="text-xl">{{ property().bedrooms }}</span>
        </div>
        <span>|</span>
        <div class="inline-flex gap-x-2">
          <span class="text-xl">Chambres</span>
          <span class="text-xl">{{ property().beds }}</span>
        </div>
      </div>
    </div>
  `
})
export class PropertyHeaderComponent {
  property = input.required<RentalPropertyDTO>();
}
