import { Component, output } from '@angular/core';

export type SortOption = 'priceAsc' | 'priceDesc' | 'nameAsc' | 'nameDesc';

@Component({
  selector: 'app-property-sort',
  template: `
    <label>Trier</label>
    <div>
      <div class="inline-flex gap-1 border-2 p-1 rounded border-[#6A6A6A]">
        <button
          [class]="baseButtonClass"
          [class.bg-[#A94A4A]]="activeSort === 'priceAsc'"
          [class.text-white]="activeSort === 'priceAsc'"
          (click)="setSort('priceAsc')">
          Prix ↑
        </button>
        <button
          [class]="baseButtonClass"
          [class.bg-[#A94A4A]]="activeSort === 'priceDesc'"
          [class.text-white]="activeSort === 'priceDesc'"
          (click)="setSort('priceDesc')">
          Prix ↓
        </button>
        <button
          [class]="baseButtonClass"
          [class.bg-[#A94A4A]]="activeSort === 'nameAsc'"
          [class.text-white]="activeSort === 'nameAsc'"
          (click)="setSort('nameAsc')">
          A-Z
        </button>
        <button
          [class]="baseButtonClass"
          [class.bg-[#A94A4A]]="activeSort === 'nameDesc'"
          [class.text-white]="activeSort === 'nameDesc'"
          (click)="setSort('nameDesc')">
          Z-A
        </button>
      </div>
    </div>
  `
})
export class PropertySortComponent {
  sortChange = output<SortOption>();

  activeSort: SortOption | null = null;
  baseButtonClass: string =
    'text-xs hover:bg-[#C26666] hover:opacity-60 hover:text-white transition-colors rounded px-2 py-1';

  setSort(sortOption: SortOption): void {
    this.activeSort = sortOption;
    this.sortChange.emit(sortOption);
  }
}
