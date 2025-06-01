import { Component, input, output } from '@angular/core';
import { CalendarModule } from 'primeng/calendar';
import { FormsModule } from '@angular/forms';
import { ButtonModule } from 'primeng/button';
import { LucideAngularModule, Calendar } from 'lucide-angular';
import { DatePickerModule } from 'primeng/datepicker';

@Component({
  selector: 'app-custom-date-picker',
  standalone: true,
  imports: [
    DatePickerModule,
    CalendarModule,
    FormsModule,
    ButtonModule,
    LucideAngularModule
  ],
  template: `
    <p-datepicker
      placeholder="Choisir une période"
      [(ngModel)]="rangeDates"
      selectionMode="range"
      (onSelect)="onRangeSelect()"
      [minDate]="minDate" />
  `,
  styles: [
    `
      :host ::ng-deep .p-datepicker {
        width: 100%;
      }

      :host ::ng-deep .p-datepicker-input {
        border-color: var(--disabled) !important;
        padding: 12px;
      }

      :host ::ng-deep .p-datepicker-input::placeholder {
        font-size: 12px;
      }

      :host ::ng-deep .p-datepicker-input {
        font-size: 12px;
      }
    `
  ]
})
export class CustomDatePickerComponent {
  public startDate = input<Date>();
  public endDate = input<Date>();

  public startDateChange = output<Date>();
  public endDateChange = output<Date>();

  readonly Calendar = Calendar;

  public rangeDates: Date[] = [];
  public formattedDateRange: string = 'Choisir une période';
  public minDate: Date = new Date();

  onRangeSelect() {
    if (this.rangeDates) {
      if (this.rangeDates[0]) {
        this.startDateChange.emit(this.rangeDates[0]);
      }
      if (this.rangeDates[1]) {
        this.endDateChange.emit(this.rangeDates[1]);
      }
    }
  }
}
