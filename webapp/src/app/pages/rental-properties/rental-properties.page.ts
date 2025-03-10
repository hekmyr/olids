import { Component, inject } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';
import { RentalProperty } from '../../interface/rental-property.interface';

@Component({
  selector: 'app-properties',
  imports: [NavBarComponent],
  templateUrl: './rental-properties.page.html'
})
export class RentalPropertiesPage {
  public rentalProperties: Array<RentalProperty> = [];

  constructor() {
    firstValueFrom(this.apiService.rentalProperties()).then((data) => {
      this.rentalProperties = [...data];
    });
  }

  apiService = inject(ApiService);
}
