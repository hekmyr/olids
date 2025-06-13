import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { dematerialize, firstValueFrom } from 'rxjs';
import { ReservationInterface } from '../../interfaces/reservation.interface';
import { FormatOdooDatePipe } from '../../pipe/format-odoo-date.pipe';
import { Heading2Directive } from '../../directives/heading2.directive';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { FormatCurrencyPipe } from '../../pipe/format-current.pipe';

@Component({
  selector: 'app-reservations',
  standalone: true,
  imports: [
    CommonModule,
    FormatOdooDatePipe,
    Heading2Directive,
    MenubarComponent,
    FooterComponent,
    FormatCurrencyPipe
  ],
  template: `
    <app-menubar />
    <div class="h-screen bg-alternative bg-background py-8">
      <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
        <div class="mb-4">
          <h2 heading2>Mes Reservations</h2>
          <p>Liste de toutes les reservations</p>
        </div>

        <div class="rounded-lg lg:shadow-md">
          <div class="hidden lg:block">
            <table class="w-full">
              <thead class="bg-gray-50">
                <tr>
                  <th
                    class="text-left"
                    *ngFor="let header of tableHeaders"
                  >
                    <div class="p-2">
                      {{ header.label }}
                    </div>
                  </th>
                </tr>
              </thead>
              <tbody class="bg-white">
                @for (reservation of reservations; track reservation.id) {
                  <tr
                    class="hover:bg-gray-50 transition-colors duration-200"
                  >
                    <td class="table-cell">
                      <div class="font-medium p-2">{{ reservation.name }}</div>
                    </td>
                    <td class="table-cell">
                      <div class="p-2">{{ reservation.dateStayBegin | formatOdooDate }}</div>
                    </td>
                    <td class="table-cell">
                      <div class="p-2">{{ reservation.dateStayEnd | formatOdooDate }}</div>
                    </td>
                    <td class="table-cell">
                      <div class="font-medium p-2">{{ reservation.priceTotal | formatCurrency }}</div>
                    </td>
                  </tr>
                }
              </tbody>
            </table>
          </div>

          <div class="lg:hidden space-y-4 p-4">
            @for (reservation of reservations; track reservation.id) {
              <div
                class="shadow-md bg-white rounded-lg p-4"
              >
                <div class="flex justify-between">
                  <h3 class="font-medium text-gray-900">{{ reservation.name }}</h3>
                  <span class="font-medium">{{ reservation.priceTotal | formatCurrency }}</span>
                </div>

                <div class="grid grid-cols-2 gap-4 text-sm">
                  <div>
                    <span class="text-gray-500">Check-in:</span>
                    <div class="font-medium">{{ reservation.dateStayBegin | formatOdooDate }}</div>
                  </div>
                  <div>
                    <span class="text-gray-500">Check-out:</span>
                    <div class="font-medium">{{ reservation.dateStayEnd | formatOdooDate }}</div>
                  </div>
                </div>
              </div>
            }
          </div>
        </div>
      </div>
    </div>
  `
})
export class ReservationsPage implements OnInit {
  public reservations: ReservationInterface[] = [];
  public isLoading = true;

  public tableHeaders = [
    { key: 'name', label: 'Nom' },
    { key: 'dateStayBegin', label: 'Check-in' },
    { key: 'dateStayEnd', label: 'Check-out' },
    { key: 'priceTotal', label: 'Prix total' }
  ];

  private apiService = inject(ApiService);

  public ngOnInit(): void {
    firstValueFrom(this.apiService.getReservations())
      .then(res => this.reservations = res.data)
      .catch(err => console.log(err))
      .finally(() => this.isLoading = false);
  }
}
