import { Component, inject, OnInit } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { SidebarComponent } from '../../components/sidebar/sidebar.component';
import { DashboardHeaderComponent } from '../account/components/dashboard-header/dashboard-header.component';
import { ReservationSortComponent } from '../../components/reservation-sort/reservation-sort.component';
import { ReservationTableComponent } from '../../components/reservation-table/reservation-table.component';
import { ReservationSummaryComponent } from '../../components/reservation-summary/reservation-summary.component';
import { ReservationInterface } from '../../interfaces/reservation.interface';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-reservations',
  imports: [
    NavBarComponent,
    SidebarComponent,
    DashboardHeaderComponent,
    ReservationSortComponent,
    ReservationTableComponent,
    ReservationSummaryComponent
  ],
  template: `
    <div class="min-h-svh flex flex-col">
      <app-nav-bar />
      <div class="flex flex-1">
        <app-sidebar activated="reservations" />
        @if (selectedReservation !== null) {
          <app-reservation-summary
            (onHidden)="hideReservationModal()"
            [reservation]="selectedReservation" />
        } @else {
          <div class="flex flex-col py-8 px-4 gap-6">
            <app-dashboard-header
              title="Mes réservations"
              description="Consultez l'historique de vos réservations" />
            <div class="flex">
              <app-reservation-sort
                [initialSortType]="sortType"
                (selected)="setSortType($event)" />
            </div>
            <app-reservation-table
              [sortBy]="sortType"
              [reservations]="reservations"
              (selected)="openReservationModal($event)" />
          </div>
        }
      </div>
    </div>
  `
})
export class ReservationsPage implements OnInit {
  public sortType: string = 'all';
  public selectedReservation: ReservationInterface | null = null;
  public reservations: Array<ReservationInterface> = [];

  private apiService = inject(ApiService);

  public ngOnInit(): void {
    firstValueFrom(this.apiService.getReservations()).then((response) => {
      this.reservations = response;
    });
  }

  public setSortType(sortType: string) {
    this.sortType = sortType;
  }

  public openReservationModal(reservation: ReservationInterface) {
    this.selectedReservation = reservation;
  }

  public hideReservationModal() {
    this.selectedReservation = null;
  }
}
