import {
  Component,
  input,
  Input,
  OnChanges,
  OnInit,
  output,
  SimpleChanges
} from '@angular/core';
import { ReservationInterface } from '../../interfaces/reservation.interface';
import { CURRENCY } from '../../constant';

@Component({
  selector: 'app-reservation-table',
  template: `
    <div class="overflow-x-auto rounded-xl border border-[#9A9BA1]">
      <table class="w-full min-w-[860px] border-collapse bg-white">
        <thead>
          <tr class="bg-[#CFD0D4]/50">
            <th class="px-4 py-2 text-left border-[#9A9BA1] w-[280px]">
              Nom de la propriété
            </th>
            <th class="px-4 py-2 text-left border-l border-[#9A9BA1] w-[200px]">
              Début du séjour
            </th>
            <th class="px-4 py-2 text-left border-l border-[#9A9BA1] w-[200px]">
              Fin du séjour
            </th>
            <th class="px-4 py-2 text-left border-l border-[#9A9BA1] w-[200px]">
              Status
            </th>
            <th class="px-4 py-2 text-left border-l border-[#9A9BA1] w-[200px]">
              Total
            </th>
            @if (filteredReservations.length > 0) {
              <th
                class="px-4 py-2 text-left border-l border-[#9A9BA1] w-[200px]"></th>
            }
          </tr>
        </thead>
        <tbody>
          @for (reservation of filteredReservations; track reservation.id) {
            <tr class="h-9">
              <td class="px-4 py-1 border-t border-[#9A9BA1]">
                {{ reservation.property.name }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ formatDate(reservation.dateStayStart) }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ formatDate(reservation.dateStayEnd) }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                <span [class]="getStatusClass(calculateStatus(reservation))">
                  {{ calculateStatus(reservation) }}
                </span>
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ calculateTotal(reservation) }}
              </td>

              @if (filteredReservations.length > 0) {
                <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                  <button
                    (click)="selected.emit(reservation)"
                    class="text-[#A94A4A] flex items-center cursor-pointer">
                    Voir plus
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      class="h-4 w-4 ml-1"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke="currentColor">
                      <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M9 5l7 7-7 7" />
                    </svg>
                  </button>
                </td>
              }
            </tr>
          }
        </tbody>
      </table>
    </div>
  `
})
export class ReservationTableComponent implements OnChanges, OnInit {
  public sortBy = input<string>('all');
  public selected = output<ReservationInterface>();
  public reservations = input.required<Array<ReservationInterface>>();

  filteredReservations: ReservationInterface[] = [];

  ngOnInit() {
    this.filterReservations();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['sortBy']) {
      this.filterReservations();
    }
  }

  filterReservations(): void {
    this.filteredReservations = this.reservations().filter((reservation) => {
      const status = this.calculateStatus(reservation);
      switch (this.sortBy()) {
        case 'future':
          return status === 'Prévu';
        case 'past':
          return status === 'Terminé';
        case 'cancelled':
          return status === 'Annulé';
        default:
          return true;
      }
    });
  }

  /**
   * Calculate the status of a reservation detail based on current date and stay dates
   * @param reservation The reservation detail to check
   * @returns The status as a string: 'Prévu', 'En cours', 'Terminé', or 'Annulé'
   */
  calculateStatus(reservation: ReservationInterface): string {
    if (reservation.isCancelled) {
      return 'Annulé';
    }

    const currentDate = new Date();
    const startDate = reservation.dateStayStart;
    const endDate = reservation.dateStayEnd;

    if (currentDate < startDate) {
      return 'Prévu';
    } else if (currentDate >= startDate && currentDate <= endDate) {
      return 'En cours';
    } else {
      return 'Terminé';
    }
  }

  /**
   * Get the CSS class for the status text
   * @param status The status string
   * @returns CSS class string
   */
  getStatusClass(status: string): string {
    switch (status) {
      case 'Prévu':
        return 'text-blue-600';
      case 'En cours':
        return 'text-green-600';
      case 'Terminé':
        return 'text-gray-600';
      case 'Annulé':
        return 'text-red-600';
      default:
        return '';
    }
  }

  /**
   * Calculate the total price for a reservation
   * @param reservation The reservation detail
   * @returns The total price as a string
   */
  calculateTotal(reservation: ReservationInterface): string {
    const startDate = reservation.dateStayStart;
    const endDate = reservation.dateStayEnd;
    const days = Math.ceil(
      (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)
    );
    return `${days * reservation.pricePerNight} ${CURRENCY}`;
  }

  /**
   * Format a date as YYYY-MM-DD
   * @param date The date to format
   * @returns Formatted date string
   */
  formatDate(date: Date): string {
    return date.toISOString().split('T')[0];
  }
}
