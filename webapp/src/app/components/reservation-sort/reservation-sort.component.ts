import { Component, input, OnInit, output } from '@angular/core';

interface ReservationSortItem {
  value: string;
  name: string;
}

@Component({
  selector: 'app-reservation-sort',
  template: `
    <div
      class="p-1 flex gap-2 rounded-sm border-1 border-[#9A9BA1] bg-[#CFD0D4]/40">
      @for (item of values; track $index) {
        <div [class]="getClass(item.value)" (click)="selectValue(item.value)">
          {{ item.name }}
        </div>
        @if ($index < values.length - 1) {
          <div class="w-[1px] bg-[#9A9BA1]"></div>
        }
      }
    </div>
  `
})
export class ReservationSortComponent implements OnInit {
  initialSortType = input<string>();
  selected = output<string>();
  currentlySelected: string | null = null;
  values: Array<ReservationSortItem> = [
    {
      name: 'Tout',
      value: 'all'
    },
    {
      name: 'Prévu',
      value: 'future'
    },
    {
      name: 'Passé',
      value: 'past'
    },
    {
      name: 'Annulé',
      value: 'cancelled'
    }
  ];

  public ngOnInit(): void {
    const initialSortType = this.initialSortType();
    if (initialSortType) {
      this.currentlySelected = initialSortType;
    }
  }

  public getClass(value: string): string {
    const baseClass = 'px-2 py-[2px] cursor-pointer rounded-sm text-sm';
    if (this.currentlySelected === value) {
      return baseClass + ' ' + 'bg-[#A94A4A] text-white';
    } else return baseClass + ' ' + 'hover:bg-[#B21212]/40';
  }

  public selectValue(value: string) {
    this.currentlySelected = value;
    this.selected.emit(value);
  }
}
