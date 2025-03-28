import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-property-image',
  standalone: true,
  imports: [CommonModule],
  template: `
    <img
      [src]="imagePath()"
      alt="Property Image"
      class="w-full h-full object-cover rounded-md" />
  `
})
export class PropertyImageComponent {
  imagePath = input<string>('images/rental_property.jpg');
}
