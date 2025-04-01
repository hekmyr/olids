import { Component } from '@angular/core';
import { LucideAngularModule, Minus, Plus, Users } from 'lucide-angular';
import { input, output } from '@angular/core';

@Component({
  selector: 'app-custom-guest-counter',
  standalone: true,
  imports: [LucideAngularModule],
  template: `
    <div
      class="flex items-center w-full input-min-width gap-5 p-3 border border-disabled-color rounded-lg">
      <div class="flex items-center gap-4">
        <i-lucide
          [img]="Minus"
          [size]="16"
          class="cursor-pointer"
          (click)="decrement()">
        </i-lucide>
        <span class="text-sm">{{ count }}</span>
        <i-lucide
          [img]="Plus"
          [size]="16"
          class="cursor-pointer"
          (click)="increment()">
        </i-lucide>
      </div>
      <div class="flex items-center gap-2 text-disabled">
        <i-lucide [img]="Users" [size]="16"></i-lucide>
        <span class="text-sm">Visiteurs</span>
      </div>
    </div>
  `,
  styles: [
    `
      .text-sm {
        font-size: 12px;
      }
    `
  ]
})
export class CustomGuestCounterComponent {
  public maxGuests = input.required<number>();
  public valueChange = output<number>();

  readonly Minus = Minus;
  readonly Plus = Plus;
  readonly Users = Users;

  count = 1;

  increment() {
    if (this.count < this.maxGuests()) {
      this.count++;
      this.valueChange.emit(this.count);
    }
  }

  decrement() {
    if (this.count > 1) {
      this.count--;
      this.valueChange.emit(this.count);
    }
  }
}
