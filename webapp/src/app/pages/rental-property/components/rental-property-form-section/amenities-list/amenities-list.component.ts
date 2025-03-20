import { Component, input } from '@angular/core';
import { RentalPropertyModel } from '../../../../../models/rental-property.model';

@Component({
  selector: 'app-amenities-list',
  standalone: true,
  template: `
    <div>
      @if (property().amenity.airConditioningAvailable) {
        <div class="flex justify-between">
          <span> Climatisation </span>
          <span>Disponible</span>
        </div>
      }

      @if (property().amenity.terraceAvailable) {
        <div class="flex justify-between">
          <span> Terrasse </span>
          <span>Disponible</span>
        </div>
      }

      @if (property().amenity.gardenAvailable) {
        <div class="flex justify-between">
          <span> Jardin </span>
          <span>Disponible</span>
        </div>
      }

      @if (property().amenity.poolAvailable) {
        <div class="flex justify-between">
          <span> Piscine </span>
          <span>Disponible</span>
        </div>
      }

      @if (property().amenity.hotTubAvailable) {
        <div class="flex justify-between">
          <span> Jacuzzi </span>
          <span>Disponible</span>
        </div>
      }

      @if (property().amenity.evChargerAvailable) {
        <div class="flex justify-between">
          <span> Borne de recharge électrique </span>
          <span>Disponible</span>
        </div>
      }
    </div>
  `
})
export class AmenitiesListComponent {
  property = input.required<RentalPropertyModel>();
}
