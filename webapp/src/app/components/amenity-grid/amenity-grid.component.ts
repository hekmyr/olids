import { Component } from '@angular/core';
import { input } from '@angular/core';
import {
  LucideAngularModule,
  Sun,
  Leaf,
  WavesLadder,
  BatteryCharging,
  Monitor,
  Dumbbell
} from 'lucide-angular';
import { IconTextComponent } from '../icon-text/icon-text.component';
import { AmenityInterface } from '../../interfaces/amenity.interface';

@Component({
  selector: 'app-amenity-grid',
  standalone: true,
  imports: [LucideAngularModule, IconTextComponent],
  template: `
    <div class="grid grid-cols-3 gap-4">
      @if (amenity().airConditioningAvailable) {
        <app-icon-text [icon]="SunIcon" text="Air Conditioning"></app-icon-text>
      }
      @if (amenity().terraceAvailable) {
        <app-icon-text [icon]="SunIcon" text="Terrace"></app-icon-text>
      }
      @if (amenity().gardenAvailable) {
        <app-icon-text [icon]="LeafIcon" text="Garden"></app-icon-text>
      }
      @if (amenity().poolAvailable) {
        <app-icon-text [icon]="WavesLadderIcon" text="Pool"></app-icon-text>
      }
      @if (amenity().hotTubAvailable) {
        <app-icon-text [icon]="WavesLadderIcon" text="Hot Tub"></app-icon-text>
      }
      @if (amenity().evChargerAvailable) {
        <app-icon-text
          [icon]="BatteryChargingIcon"
          text="EV Charger"></app-icon-text>
      }
      @if (amenity().indoorFireplaceAvailable) {
        <app-icon-text [icon]="SunIcon" text="Indoor Fireplace"></app-icon-text>
      }
      @if (amenity().dedicatedWorkspaceAvailable) {
        <app-icon-text [icon]="MonitorIcon" text="Workspace"></app-icon-text>
      }
      @if (amenity().gymAvailable) {
        <app-icon-text [icon]="DumbbellIcon" text="Gym"></app-icon-text>
      }
    </div>
  `
})
export class AmenityGridComponent {
  public amenity = input.required<AmenityInterface>();

  readonly SunIcon = Sun;
  readonly LeafIcon = Leaf;
  readonly WavesLadderIcon = WavesLadder;
  readonly BatteryChargingIcon = BatteryCharging;
  readonly MonitorIcon = Monitor;
  readonly DumbbellIcon = Dumbbell;
}
