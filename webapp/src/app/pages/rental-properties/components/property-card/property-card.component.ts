import { Component, inject, input } from '@angular/core';
import { RentalProperty } from '../../../../interface/rental-property.interface';
import { Router } from '@angular/router';
import { CURRENCY } from '../../../../constant';

@Component({
  selector: 'app-property-card',
  imports: [],
  template: `
    <div class="flex flex-col gap-2">
      <img
        class="w-full aspect-square rounded-sm cursor-pointer hover:brightness-120"
        (click)="redirectToPage()"
        src="images/sign_component_side_img.jpg" />
      <div>
        <div class="text-lg">{{ property().name }}</div>
        <div class="flex gap-2">
          <span class="font-bold">{{ property().pricePerNight }}</span>
          <span class="font-bold">{{ currency }}</span>
        </div>
      </div>
    </div>
  `
})
export class PropertyCardComponent {
  public property = input.required<RentalProperty>();
  public currency = CURRENCY;
  router = inject(Router);
  public redirectToPage() {
    this.router.navigate(['/property', this.property().id]);
  }
}
