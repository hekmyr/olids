import { Component, input } from '@angular/core';
import { RentalPropertyAccessibilityAccordionComponent } from '../rental-property-accessibility-accordion/rental-property-accessibility-accordion.component';
import { AccordionComponent } from '../../../../../components/accordion/accordion.component';
import { RentalPropertyDTO } from '../../../../../dto/rental-property.dto';

@Component({
  selector: 'app-property-description',
  standalone: true,
  template: `
    <div class="flex flex-col gap-5">
      @if (property().description != '') {
        <app-accordion title="Description" [text]="property().description" />
      }
      <app-rental-property-accessibility-accordion
        [accessibility]="property().accessibility" />
    </div>
  `,
  imports: [AccordionComponent, RentalPropertyAccessibilityAccordionComponent]
})
export class PropertyDescriptionComponent {
  property = input.required<RentalPropertyDTO>();
}
