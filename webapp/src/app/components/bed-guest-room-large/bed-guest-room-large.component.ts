import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-bed-guest-room-large',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div class="flex items-center text-xl">
      <span class="font-bold">{{ beds() }}&nbsp;</span><span> lits</span>
      <span class="mx-2">|</span>
      <span class="font-bold">{{ guests() }}&nbsp;</span><span> visiteurs</span>
      <span class="mx-2">|</span>
      <span class="font-bold">{{ rooms() }}&nbsp;</span><span> chambres</span>
    </div>
  `
})
export class BedGuestRoomLargeComponent {
  public beds = input.required<number>();
  public guests = input.required<number>();
  public rooms = input.required<number>();
}
