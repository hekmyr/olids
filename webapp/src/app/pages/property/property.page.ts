import { Component, inject, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { ApiService } from '../../services/api.service';
import { CommonModule } from '@angular/common';
import { MenubarComponent } from '../../components/navigation/menubar.component';

import { RentalPropertyInterface } from '../../interfaces/rental-property.interface';
import { H3Component } from '../../components/typography/h3.component';
import { H4Component } from '../../components/typography/h4.component';
import { BedGuestRoomLargeComponent } from '../../components/bed-guest-room-large/bed-guest-room-large.component';
import { PriceLargeComponent } from '../../components/price-large/price-large.component';

import { CustomDatePickerComponent } from '../../components/custom-date-picker/custom-date-picker.component';
import { FormBuilder, Validators } from '@angular/forms';
import { CustomGuestCounterComponent } from '../../components/custom-guest-counter/custom-guest-counter.component';
import { TotalPriceComponent } from '../../components/total-price/total-price.component';
import { ThreeDButtonComponent } from '../../components/three-d-button/three-d-button.component';
import { AmenityGridComponent } from '../../components/amenity-grid/amenity-grid.component';
import { AccessibilityGridComponent } from '../../components/accessibility-grid/accessibility-grid.component';

@Component({
  selector: 'app-property',
  standalone: true,
  imports: [
    CommonModule,
    MenubarComponent,
    H3Component,
    H4Component,
    BedGuestRoomLargeComponent,
    PriceLargeComponent,
    CustomDatePickerComponent,
    CustomGuestCounterComponent,
    TotalPriceComponent,
    ThreeDButtonComponent,
    AmenityGridComponent,
    AccessibilityGridComponent
  ],
  template: `
    <div class="h-screen flex flex-col">
      <app-menubar></app-menubar>
      @if (property) {
        <div class="px-page pt-page flex gap-16">
          <img
            src="images/rental_property.jpg"
            alt="Property Image"
            class="flex h-[calc(100vh-160px)] w-full object-cover pb-page" />
          <div class="min-w-[384px] max-w-[500px] flex flex-col gap-8">
            <div class="flex flex-col gap-3">
              <app-h3>{{ property.name }}</app-h3>
              <app-bed-guest-room-large
                [beds]="property.beds"
                [guests]="stayForm.value.guests ?? 1"
                [rooms]="property.bedrooms" />
              <div class="inline-block">
                <app-price-large [price]="property.pricePerNight" />
              </div>
            </div>
            <div class="flex flex-col gap-6">
              <div class="flex flex-col gap-3">
                <app-custom-date-picker
                  (startDateChange)="onStartDateChange($event)"
                  (endDateChange)="
                    onEndDateChange($event)
                  "></app-custom-date-picker>
                <app-custom-guest-counter
                  [maxGuests]="property.maxGuests"
                  (valueChange)="
                    onGuestCountChange($event)
                  "></app-custom-guest-counter>
              </div>
              <app-total-price
                [days]="calculateDays()"
                [price]="property.pricePerNight"></app-total-price>
              <app-three-d-button>Réserver</app-three-d-button>
            </div>
            <div class="flex flex-col gap-6">
              <div class="flex flex-col gap-4">
                <app-h4>Commodités</app-h4>
                <app-amenity-grid
                  [amenity]="property.amenity"></app-amenity-grid>
              </div>
              <div class="flex flex-col gap-4">
                <app-h4>Accessibilités</app-h4>
                <app-accessibility-grid
                  [accessibility]="
                    property.accessibility
                  "></app-accessibility-grid>
              </div>
            </div>
          </div>
        </div>
      }
    </div>
  `
})
export class PropertyPage implements OnInit {
  private fb = inject(FormBuilder);
  private route = inject(ActivatedRoute);
  private apiService = inject(ApiService);
  public property: RentalPropertyInterface | null = null;

  public stayForm = this.fb.group({
    stayStart: [new Date(), [Validators.required]],
    stayEnd: [null as Date | null, [Validators.required]],
    guests: [1, [Validators.required, Validators.min(1)]]
  });

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (!id) {
      console.error('Property ID not found in route');
      return;
    }
    firstValueFrom(this.apiService.rentalProperty(id))
      .then((data) => {
        this.property = data;
        this.stayForm.controls.guests.addValidators([
          Validators.max(this.property.maxGuests ?? 1)
        ]);
        this.stayForm.controls.guests.updateValueAndValidity();
      })
      .catch((error) => console.error('Error fetching property:', error));
  }

  calculateDays(): number {
    const start = this.stayForm.value.stayStart;
    const end = this.stayForm.value.stayEnd;
    if (start && end && end > start) {
      const diffTime = Math.abs(end.getTime() - start.getTime());
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      return diffDays;
    }
    return 0;
  }
  onStartDateChange(date: Date) {
    console.log('Start date changed:', date);
    this.stayForm.patchValue({ stayStart: date });
    console.log('Form values:', this.stayForm.value);
  }

  onEndDateChange(date: Date) {
    console.log('End date changed:', date);
    this.stayForm.patchValue({ stayEnd: date });
    console.log('Form values:', this.stayForm.value);
  }

  onGuestCountChange(count: number) {
    console.log('Guest count changed:', count);
    this.stayForm.patchValue({ guests: count });
    console.log('Form values:', this.stayForm.value);
  }
}
