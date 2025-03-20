import { Component, inject, input, output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Reservation } from '../../interfaces/reservation.interface';
import { DashboardHeaderComponent } from '../../pages/account/components/dashboard-header/dashboard-header.component';
import { Button3dComponent } from '../button-3d/button-3d.component';
import { BillingInformationService } from '../../services/billing-information.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reservation-summary',
  standalone: true,
  imports: [CommonModule, DashboardHeaderComponent, Button3dComponent],
  template: `
    <div class="flex flex-col w-[860px] gap-[10px] px-8 py-[18px]">
      <div>
        <span
          class="text-[#A94A4A] text-lg flex items-center cursor-pointer"
          (click)="onHidden.emit()">
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            viewBox="0 0 24 24"
            fill="none"
            stroke="currentColor"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
            class="mr-1">
            <path d="M15 18l-6-6 6-6" />
          </svg>
          Retour
        </span>
      </div>
      <div class="flex flex-col gap-6">
        <app-dashboard-header title="Chalet Mont-Blanc" />

        <img
          src="images/sign_component_side_img.jpg"
          alt="Chalet Mont-Blanc"
          class="w-full h-[460px] rounded-lg object-cover" />

        <app-dashboard-header title="Détails de réservation" />

        <div class="flex justify-between">
          <div class="min-w-[320px]">
            <div class="flex justify-between">
              <span class="text-lg">Nombre de voyageur</span>
              <span class="text-lg">{{ getGuestCount() }}</span>
            </div>
            <div class="flex justify-between">
              <span class="text-lg">Début du séjour</span>
              <span class="text-lg">{{ formatDate(getStartDate()) }}</span>
            </div>
            <div class="flex justify-between">
              <span class="text-lg">Fin du séjour</span>
              <span class="text-lg">{{ formatDate(getEndDate()) }}</span>
            </div>
            <div class="flex justify-between">
              <span class="text-lg">Durée du séjour</span>
              <span class="text-lg">{{ getDurationInDays() }} jours</span>
            </div>
          </div>

          <div class="w-[1px] bg-[#9A9BA1] h-auto self-stretch"></div>

          <div class="min-w-[320px]">
            <div class="flex justify-between">
              <span class="text-lg">Date de réservation</span>
              <span class="text-lg">{{
                formatDate(getReservationDate())
              }}</span>
            </div>
            <div class="flex justify-between">
              <span class="text-lg">Numéro de carte</span>
              <span class="text-lg">{{ getMaskedCardNumber() }}</span>
            </div>
            <div class="flex justify-between">
              <span class="text-lg">Total</span>
              <span class="text-lg">{{ getTotalPrice() }} EUR</span>
            </div>
          </div>
        </div>

        <div class="flex items-center gap-4">
          <app-button-3d text="Annuler" (click)="cancelReservation()" />

          <span
            class="text-lg text-[#A94A4A] cursor-pointer"
            (click)="redirectToPropertyPage()"
            >Plus d'information</span
          >
        </div>
      </div>
    </div>
  `
})
export class ReservationSummaryComponent {
  reservation = input.required<Reservation>();
  onHidden = output<void>();

  getPropertyName(): string {
    return this.reservation().details[0].property?.name || 'Chalet Mont-Blanc';
  }

  getGuestCount(): number {
    return this.reservation().details[0].guest;
  }

  getStartDate(): Date {
    return (
      this.reservation().details[0].dateStayStart || new Date('2025-03-01')
    );
  }

  getEndDate(): Date {
    return this.reservation().details[0].dateStayEnd || new Date('2025-07-05');
  }

  getReservationDate(): Date {
    return new Date('2025-02-06');
  }

  formatDate(date: Date): string {
    if (!date) return '';
    return date.toISOString().split('T')[0].split('-').join('-');
  }

  getDurationInDays(): number {
    const start = this.getStartDate();
    const end = this.getEndDate();
    const diffTime = Math.abs(end.getTime() - start.getTime());
    return Math.ceil(diffTime / (1000 * 60 * 60 * 24)) || 18;
  }

  billingInformationService = inject(BillingInformationService);

  getMaskedCardNumber(): string {
    return this.billingInformationService.maskCardNumber('4545123456789012');
  }

  getTotalPrice(): string {
    const duration = this.getDurationInDays();
    const pricePerNight = this.reservation().details[0].pricePerNight;
    const total = pricePerNight ? duration * pricePerNight : 4300;
    return total.toLocaleString();
  }

  router = inject(Router);

  public redirectToPropertyPage() {
    this.router.navigate([
      `/property/${this.reservation().details[0].property.id}`
    ]);
  }

  public cancelReservation() {}
}
