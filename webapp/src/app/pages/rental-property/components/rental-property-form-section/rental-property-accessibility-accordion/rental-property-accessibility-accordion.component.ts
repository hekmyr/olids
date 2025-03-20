import { Component, input, signal, effect } from '@angular/core';
import { AccessibilityModel } from '../../../../../models/accessibility.model';

@Component({
  selector: 'app-rental-property-accessibility-accordion',
  template: `
    <div
      class="w-full text-2xl pb-2 select-none cursor-pointer"
      (click)="toggleOpen()">
      Accessibilités
    </div>
    <hr />
    @if (isOpen()) {
      <div class="py-4">
        @if (accessibility().toiletGrabBarAvailable) {
          <div class="flex justify-between">
            <span>Barre d'appui pour toilettes</span> <span>Disponible</span>
          </div>
        }
        @if (accessibility().showerGrabBarAvailable) {
          <div class="flex justify-between">
            <span>Barre d'appui pour douche</span> <span>Disponible</span>
          </div>
        }
        @if (accessibility().stepFreeShowerAvailable) {
          <div class="flex justify-between">
            <span>Douche sans marche</span> <span>Disponible</span>
          </div>
        }
        @if (accessibility().showerBathChairAvailable) {
          <div class="flex justify-between">
            <span>Chaise de douche/bain</span> <span>Disponible</span>
          </div>
        }
        @if (accessibility().stepFreeBedroomAccessAvailable) {
          <div class="flex justify-between">
            <span>Accès à la chambre sans marche</span>
            <span>Disponible</span>
          </div>
        }
        @if (accessibility().wideBedroomEntranceAvailable) {
          <div class="flex justify-between">
            <span>Entrée de chambre large</span> <span>Disponible</span>
          </div>
        }
        @if (accessibility().stepFreeAccessAvailable) {
          <div class="flex justify-between">
            <span>Accès sans marche</span> <span>Disponible</span>
          </div>
        }
      </div>
    }
  `
})
export class RentalPropertyAccessibilityAccordionComponent {
  accessibility = input.required<AccessibilityModel>();
  open = input<boolean>(false);

  isOpen = signal(false);

  constructor() {
    this.isOpen.set(this.open());

    effect(() => {
      this.isOpen.set(this.open());
    });
  }

  toggleOpen() {
    this.isOpen.update((value) => !value);
  }
}
