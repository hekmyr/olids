import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RentalPropertyInterface } from '../../interfaces/rental-property.interface';
import { RentalPropertyCardComponent } from '../rental-property-card/rental-property-card.component';

@Component({
  selector: 'app-rental-property-grid',
  standalone: true,
  imports: [CommonModule, RentalPropertyCardComponent],
  template: `
    <div
      class="grid grid-cols-[repeat(auto-fit,minmax(300px,1fr))] gap-x-4 gap-y-6">
      @for (property of properties(); track property.id) {
        <app-rental-property-card [property]="property" />
      }
    </div>
  `
})
export class RentalPropertyGridComponent {
  public properties = input.required<RentalPropertyInterface[]>();
}
