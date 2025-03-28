import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RentalPropertyInterface } from '../../interfaces/rental-property.interface';
import { H4Component } from '../typography/h4.component';
import { BedGuestRoomComponent } from '../bed-guest-room/bed-guest-room.component';
import { PriceComponent } from '../price/price.component';

@Component({
  selector: 'app-rental-property-card',
  standalone: true,
  imports: [CommonModule, H4Component, BedGuestRoomComponent, PriceComponent],
  template: `
    <div
      class="flex flex-col gap-2 p-3 bg-white rounded-md inline-flex shadow-md shadow-black/25">
      <img
        src="images/rental_property.jpg"
        alt="Rental Property Image"
        class="w-[276px] h-[276px] rounded-md object-cover" />
      <div class="flex flex-col gap-1">
        <app-h4>{{ property().name }}</app-h4>
        <app-bed-guest-room
          [beds]="property().beds"
          [guests]="3"
          [rooms]="property().bedrooms"></app-bed-guest-room>
        <span class="text-xs text-disabled italic">Disponible</span>
      </div>
      <div class="flex items-center justify-between">
        <app-price [price]="property().pricePerNight"></app-price>
        <a
          href="/property/{{ property().id }}"
          class="text-accent-1 font-bold ml-2"
          >En savoir plus</a
        >
      </div>
    </div>
  `
})
export class RentalPropertyCardComponent {
  public property = input.required<RentalPropertyInterface>();
}
