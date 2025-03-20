import {
  Component,
  input,
  Input,
  OnChanges,
  OnInit,
  output,
  SimpleChanges
} from '@angular/core';
import { Reservation } from '../../interface/reservation.interface';
import { ReservationDetail } from '../../interface/reservation-detail.interface';
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
                {{ reservation.details[0].property.name }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ formatDate(reservation.details[0].dateStayStart) }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ formatDate(reservation.details[0].dateStayEnd) }}
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                <span
                  [class]="
                    getStatusClass(calculateStatus(reservation.details[0]))
                  ">
                  {{ calculateStatus(reservation.details[0]) }}
                </span>
              </td>
              <td class="px-4 py-1 border-l border-t border-[#9A9BA1]">
                {{ calculateTotal(reservation.details[0]) }}
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
  public selected = output<Reservation>();

  reservations: Reservation[] = [
    {
      id: '1',
      details: [
        {
          id: '1',
          pricePerNight: 100,
          dateStayStart: new Date('2025-03-01'),
          dateStayEnd: new Date('2025-07-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '1',
            cardNumber: '1234567890123456',
            monthExpiration: 12,
            yearExpiration: 23,
            isDefault: false
          },
          property: {
            id: '1',
            accessibility: {
              id: '1',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '1',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '2',
      details: [
        {
          id: '2',
          pricePerNight: 100,
          dateStayStart: new Date('2025-03-01'),
          dateStayEnd: new Date('2025-07-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '2',
            cardNumber: '1234567890123456',
            monthExpiration: 12,
            yearExpiration: 23,
            isDefault: false
          },
          property: {
            id: '2',
            accessibility: {
              id: '2',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '2',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '3',
      details: [
        {
          id: '3',
          pricePerNight: 100,
          dateStayStart: new Date('2024-12-01'),
          dateStayEnd: new Date('2025-01-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '3',
            cardNumber: '2346542342324434',
            monthExpiration: 12,
            yearExpiration: 28,
            isDefault: false
          },
          property: {
            id: '3',
            accessibility: {
              id: '3',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '3',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '4',
      details: [
        {
          id: '4',
          pricePerNight: 100,
          dateStayStart: new Date('2025-01-01'),
          dateStayEnd: new Date('2025-03-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '3',
            cardNumber: '2346542342324434',
            monthExpiration: 12,
            yearExpiration: 28,
            isDefault: false
          },
          property: {
            id: '4',
            accessibility: {
              id: '4',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '4',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '5',
      details: [
        {
          id: '5',
          pricePerNight: 100,
          dateStayStart: new Date('2024-07-01'),
          dateStayEnd: new Date('2024-12-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '3',
            cardNumber: '2346542342324434',
            monthExpiration: 12,
            yearExpiration: 28,
            isDefault: false
          },
          property: {
            id: '5',
            accessibility: {
              id: '5',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '5',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '6',
      details: [
        {
          id: '6',
          pricePerNight: 100,
          dateStayStart: new Date('2025-03-01'),
          dateStayEnd: new Date('2025-07-05'),
          isCancelled: true,
          guest: 4,
          billingInformation: {
            id: '3',
            cardNumber: '2346542342324434',
            monthExpiration: 12,
            yearExpiration: 28,
            isDefault: false
          },
          property: {
            id: '6',
            accessibility: {
              id: '6',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '6',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    },
    {
      id: '7',
      details: [
        {
          id: '7',
          pricePerNight: 100,
          dateStayStart: new Date('2025-03-01'),
          dateStayEnd: new Date('2025-07-05'),
          isCancelled: false,
          guest: 4,
          billingInformation: {
            id: '3',
            cardNumber: '2346542342324434',
            monthExpiration: 12,
            yearExpiration: 28,
            isDefault: false
          },
          property: {
            id: '7',
            accessibility: {
              id: '7',
              toiletGrabBarAvailable: true,
              showerGrabBarAvailable: true,
              stepFreeShowerAvailable: true,
              showerBathChairAvailable: true,
              stepFreeBedroomAccessAvailable: true,
              wideBedroomEntranceAvailable: true,
              stepFreeAccessAvailable: true
            },
            amenity: {
              id: '7',
              airConditioningAvailable: true,
              terraceAvailable: true,
              gardenAvailable: true,
              poolAvailable: true,
              hotTubAvailable: true,
              evChargerAvailable: true,
              indoorFireplaceAvailable: true,
              outdoorFireplaceAvailable: true,
              dedicatedWorkspaceAvailable: true,
              gymAvailable: true
            },
            name: 'Chalet Mont-Blanc',
            description: 'A cozy chalet in the mountains',
            listed: true,
            pricePerNight: 100,
            beds: 2,
            bedrooms: 1,
            bathrooms: 1,
            street: 'Mountain Road',
            number: '123',
            postalCode: '12345'
          }
        }
      ]
    }
  ];
  filteredReservations: Reservation[] = [];

  ngOnInit() {
    this.filterReservations();
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['sortBy']) {
      this.filterReservations();
    }
  }

  filterReservations(): void {
    this.filteredReservations = this.reservations.filter((reservation) => {
      const status = this.calculateStatus(reservation.details[0]);
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
    console.log(this.reservations, this.filteredReservations);
  }

  /**
   * Calculate the status of a reservation detail based on current date and stay dates
   * @param detail The reservation detail to check
   * @returns The status as a string: 'Prévu', 'En cours', 'Terminé', or 'Annulé'
   */
  calculateStatus(detail: ReservationDetail): string {
    if (detail.isCancelled) {
      return 'Annulé';
    }

    const currentDate = new Date();
    const startDate = detail.dateStayStart;
    const endDate = detail.dateStayEnd;

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
   * @param detail The reservation detail
   * @returns The total price as a string
   */
  calculateTotal(detail: ReservationDetail): string {
    const startDate = detail.dateStayStart;
    const endDate = detail.dateStayEnd;
    const days = Math.ceil(
      (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24)
    );
    return `${days * detail.pricePerNight} ${CURRENCY}`;
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
