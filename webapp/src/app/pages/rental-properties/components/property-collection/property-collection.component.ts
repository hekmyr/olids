import { Component, inject } from '@angular/core';
import { RentalProperty } from '../../../../interface/rental-property.interface';
import { firstValueFrom } from 'rxjs';
import { ApiService } from '../../../../services/api.service';
import { PropertyCardComponent } from '../property-card/property-card.component';
import { RentalPropertyRequestDTO } from '../../../../dto/rental-property-request.dto';
import { InputComponent } from '../../../../components/input/input.component';

@Component({
  selector: 'app-property-collection',
  imports: [PropertyCardComponent, InputComponent],
  template: `
    <app-input
      type="date"
      label="Début du séjour"
      [min]="minStartDate"
      (value)="onStartDateChange($event)" />
    <app-input
      type="date"
      label="Fin du séjour"
      [min]="minEndDate"
      [disabled]="startDateFormValue == null"
      (value)="onEndDateChange($event)" />
    <div class="grid grid-cols-5 gap-x-12 gap-y-4 ">
      @for (property of rentalProperties; track property.id) {
        <app-property-card [property]="property" />
      }
    </div>
  `
})
export class PropertyCollectionComponent {
  public rentalProperties: Array<RentalProperty> = [];
  public startDateFormValue: Date | null = null;
  public endDateFormValue: Date | null = null;
  public minStartDate: string = '';
  public minEndDate: string = '';

  constructor() {
    const today = new Date();
    this.minStartDate = this.formatDateForInput(today);
    firstValueFrom(
      this.apiService.rentalProperties(new RentalPropertyRequestDTO())
    ).then((data) => {
      this.rentalProperties = data;
    });
  }

  private formatDateForInput(date: Date): string {
    return date.toISOString().split('T')[0];
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
}
