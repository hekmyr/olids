import { Component } from '@angular/core';
import { input } from '@angular/core';
import { LucideAngularModule, Accessibility, DoorOpen } from 'lucide-angular';
import { IconTextComponent } from '../icon-text/icon-text.component';
import { AccessibilityInterface } from '../../interfaces/accessibility.interface';

@Component({
  selector: 'app-accessibility-grid',
  standalone: true,
  imports: [LucideAngularModule, IconTextComponent],
  template: `
    <div class="grid grid-cols-3 gap-4">
      @if (accessibility().toiletGrabBarAvailable) {
        <app-icon-text
          [icon]="AccessibilityIcon"
          text="Toilet Grab Bar"></app-icon-text>
      }
      @if (accessibility().showerGrabBarAvailable) {
        <app-icon-text
          [icon]="AccessibilityIcon"
          text="Shower Grab Bar"></app-icon-text>
      }
      @if (accessibility().stepFreeShowerAvailable) {
        <app-icon-text
          [icon]="AccessibilityIcon"
          text="Step-Free Shower"></app-icon-text>
      }
      @if (accessibility().showerBathChairAvailable) {
        <app-icon-text
          [icon]="AccessibilityIcon"
          text="Shower Bath Chair"></app-icon-text>
      }
      @if (accessibility().stepFreeBedroomAccessAvailable) {
        <app-icon-text
          [icon]="DoorOpenIcon"
          text="Step-Free Bedroom"></app-icon-text>
      }
      @if (accessibility().wideBedroomEntranceAvailable) {
        <app-icon-text
          [icon]="DoorOpenIcon"
          text="Wide Bedroom Entrance"></app-icon-text>
      }
      @if (accessibility().stepFreeAccessAvailable) {
        <app-icon-text
          [icon]="AccessibilityIcon"
          text="Step-Free Access"></app-icon-text>
      }
    </div>
  `
})
export class AccessibilityGridComponent {
  public accessibility = input.required<AccessibilityInterface>();

  readonly AccessibilityIcon = Accessibility;
  readonly DoorOpenIcon = DoorOpen;
}
