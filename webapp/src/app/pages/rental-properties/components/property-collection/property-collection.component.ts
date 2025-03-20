import { Component, inject } from '@angular/core';
import { RentalPropertyInterface } from '../../../../interfaces/rental-property.interface';
import { firstValueFrom } from 'rxjs';
import { ApiService } from '../../../../services/api.service';
import { PropertyCardComponent } from '../property-card/property-card.component';
import { RentalPropertyRequestDTO } from '../../../../dtos/rental-property-request.dto';
import { InputComponent } from '../../../../components/input/input.component';
import {
  PropertySortComponent,
  SortOption
} from './property-sort/property-sort.component';

@Component({
  selector: 'app-property-collection',
  imports: [PropertyCardComponent, InputComponent, PropertySortComponent],
  template: `
    <div class="flex flex-col gap-8">
      <div class="flex justify-between">
        <div class="flex gap-8">
          <app-input
            type="date"
            label="Début du séjour"
            [initialValue]="minStartDate"
            [min]="minStartDate"
            (value)="onStartDateChange($event)" />
          <app-input
            type="date"
            label="Fin du séjour"
            [min]="minEndDate"
            [disabled]="startDateFormValue == null"
            (value)="onEndDateChange($event)" />
        </div>
        <app-property-sort
          (sortChange)="onSortChange($event)"></app-property-sort>
      </div>
      <div>
        <div class="grid grid-cols-5 gap-x-12 gap-y-8 ">
          @if (startDateFormValue != null) {
            @for (property of rentalProperties; track property.id) {
              <app-property-card
                [property]="property"
                [startDate]="startDateFormValue"
                [endDate]="endDateFormValue" />
            }
          } @else {
            @for (property of rentalProperties; track property.id) {
              <app-property-card [property]="property" />
            }
          }
        </div>
      </div>
    </div>
  `
})
export class PropertyCollectionComponent {
  public rentalProperties: Array<RentalPropertyInterface> = [];
  public startDateFormValue: Date = new Date();
  public endDateFormValue: Date | null = null;
  public minStartDate: string = '';
  public minEndDate: string = '';

  constructor() {
    const today = new Date();
    this.minStartDate = this.formatDateForInput(today);
    this.minEndDate = this.formatDateForInput(today);
    this.startDateFormValue = today;

    firstValueFrom(
      this.apiService.rentalProperties(new RentalPropertyRequestDTO())
    ).then((data) => {
      this.rentalProperties = data;
    });
  }

  private formatDateForInput(date: Date): string {
    return date.toISOString().split('T')[0];
  }

  public onSortChange(sortOption: SortOption): void {
    this.rentalProperties = this.getSortedProperties(sortOption);
  }

  apiService = inject(ApiService);

  public onStartDateChange(dateStr: string) {
    const selectedDate = new Date(dateStr);
    this.minEndDate = dateStr;
    this.startDateFormValue = selectedDate;

    const request = new RentalPropertyRequestDTO();
    request.startDate = selectedDate;
    firstValueFrom(this.apiService.rentalProperties(request)).then((data) => {
      this.rentalProperties = data;
    });
  }

  public onEndDateChange(dateStr: string) {
    const selectedDate = new Date(dateStr);
    this.endDateFormValue = selectedDate;
    const request = new RentalPropertyRequestDTO();
    request.endDate = selectedDate;
    firstValueFrom(this.apiService.rentalProperties(request)).then((data) => {
      this.rentalProperties = data;
    });
  }

  public getSortedProperties(
    sortOption: string
  ): Array<RentalPropertyInterface> {
    if (!this.rentalProperties.length) return [];

    const properties = [...this.rentalProperties];

    switch (sortOption) {
      case 'priceAsc':
        return properties.sort((a, b) => a.pricePerNight - b.pricePerNight);
      case 'priceDesc':
        return properties.sort((a, b) => b.pricePerNight - a.pricePerNight);
      case 'nameAsc':
        return properties.sort((a, b) => a.name.localeCompare(b.name));
      case 'nameDesc':
        return properties.sort((a, b) => b.name.localeCompare(a.name));
      default:
        return properties;
    }
  }
}
