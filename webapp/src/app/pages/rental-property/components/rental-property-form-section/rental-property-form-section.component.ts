import { Component, inject, input, OnInit } from '@angular/core';
import { InputComponent } from '../../../../components/input/input.component';
import { RentalPropertyDTO } from '../../../../dto/rental-property.dto';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { AmenitiesListComponent } from './amenities-list/amenities-list.component';
import { PriceSummaryComponent } from './price-summary/price-summary.component';
import { PropertyDescriptionComponent } from './property-description/property-description.component';
import { PropertyHeaderComponent } from './property-header-component/property-header.component';
import { Button3dComponent } from '../../../../components/button-3d/button-3d.component';
import { ApiService } from '../../../../services/api.service';
import { ReservationCreateDTO } from '../../../../dto/reservation-create-dto';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-rental-property-form-section',
  imports: [
    ReactiveFormsModule,
    InputComponent,
    Button3dComponent,
    PropertyHeaderComponent,
    AmenitiesListComponent,
    PriceSummaryComponent,
    PropertyDescriptionComponent
  ],
  template: `
    <div class="w-full">
      <div class="mx-auto mt-16 flex flex-col w-[600px] gap-8">
        <app-property-header [property]="rentalProperty()" />
        <div class="flex flex-col gap-3"></div>
        <div class="flex justify-between gap-3">
          <app-input
            class="basis-1/4"
            label="Nombre de voyageur"
            (value)="onTravelerCountChanges($event)" />
          <app-input
            class="basis-1/3"
            type="date"
            label="Début du séjour"
            [min]="minStartDate"
            (value)="onStartDateChange($event)" />
          <app-input
            class="basis-1/3"
            type="date"
            label="Fin du séjour"
            [min]="minEndDate"
            [disabled]="startDateFormValue == null"
            (value)="onEndDateChange($event)" />
        </div>
        <app-amenities-list [property]="rentalProperty()" />
        <app-price-summary
          [property]="rentalProperty()"
          [numberOfNights]="numberOfNights"
          [totalCost]="totalCost"
          [currency]="currency" />
        <app-button-3d
          class="w-[160px] ml-auto"
          text="Réserver"
          [disabled]="!this.bookingForm.valid"
          (click)="onSubmit()" />
        <app-property-description [property]="rentalProperty()" />
      </div>
    </div>
  `
})
export class RentalPropertyFormSectionComponent {
  public rentalProperty = input.required<RentalPropertyDTO>();

  fb = inject(FormBuilder);

  bookingForm = this.fb.group({
    dates: this.fb.group({
      startDate: this.fb.control<Date | null>(null, Validators.required),
      endDate: this.fb.control<Date | null>(null, Validators.required)
    }),
    travelers: this.fb.control<number>(0, Validators.min(1))
  });

  get travelersFormValue(): number | null {
    return this.bookingForm.controls.travelers.getRawValue();
  }

  get startDateFormValue(): Date | null {
    return this.bookingForm.controls.dates.controls.startDate.value;
  }

  get endDateFormValue(): Date | null {
    return this.bookingForm.controls.dates.controls.endDate.value;
  }

  numberOfNights: number = 0;
  totalCost: number = 0;
  currency = 'EUR';
  minStartDate: string = '';
  minEndDate: string = '';

  constructor() {
    const today = new Date();
    this.minStartDate = this.formatDateForInput(today);
    this.minEndDate = this.minStartDate;
  }

  private formatDateForInput(date: Date): string {
    return date.toISOString().split('T')[0];
  }

  public onTravelerCountChanges(countStr: string) {
    let count = parseInt(countStr);
    this.bookingForm.controls.travelers.setValue(count);
  }

  public onStartDateChange(dateStr: string) {
    const selectedDate = new Date(dateStr);

    this.bookingForm.controls.dates.controls.startDate.setValue(selectedDate);

    const nextDay = new Date(selectedDate);
    nextDay.setDate(nextDay.getDate() + 1);
    this.minEndDate = this.formatDateForInput(nextDay);
    this.calculateStayDetails();
  }

  public onEndDateChange(dateStr: string) {
    const selectedDate = new Date(dateStr);
    this.bookingForm.controls.dates.controls.endDate.setValue(selectedDate);
    this.calculateStayDetails();
  }

  private calculateStayDetails() {
    const startDate = this.startDateFormValue;
    const endDate = this.endDateFormValue;
    if (startDate && endDate) {
      const timeDiff = endDate.getTime() - startDate.getTime();
      this.numberOfNights = Math.ceil(timeDiff / (1000 * 3600 * 24));

      if (this.rentalProperty().pricePerNight) {
        this.totalCost =
          this.numberOfNights * this.rentalProperty().pricePerNight;
      }
    } else {
      this.numberOfNights = 0;
      this.totalCost = 0;
    }
  }

  apiService = inject(ApiService);

  public onSubmit() {
    if (!this.bookingForm.valid) return;

    const travelers = this.bookingForm.controls.travelers.value;
    const startDate = this.startDateFormValue;
    const endDate = this.endDateFormValue;

    if (travelers && startDate && endDate) {
      const payload = new ReservationCreateDTO(
        this.rentalProperty().id,
        startDate,
        endDate
      );
      firstValueFrom(this.apiService.createReservation([payload])).then(
        (reservation) => {
          console.log(reservation);
        }
      );
    }

    console.log('Booking submitted', {
      property: this.rentalProperty(),
      startDate: startDate,
      endDate: endDate,
      numberOfNights: this.numberOfNights,
      totalCost: this.totalCost,
      travelers: this.bookingForm.get('travelers')?.value
    });
  }
}
