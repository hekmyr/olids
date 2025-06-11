import { Component, inject, OnInit } from '@angular/core';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { SearchBarComponent } from '../../components/search/search-bar.component';
import { FooterComponent } from '../../components/footer/footer.component';
import { RentalPropertyInterface } from '../../interfaces/rental-property.interface';
import { RentalPropertyGridComponent } from '../../components/rental-property-grid/rental-property-grid.component';
import { H2Component } from '../../components/typography/h2.component';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';
import { RentalPropertyRequestDTO } from '../../dtos/rental-property-request.dto';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    MenubarComponent,
    SearchBarComponent,
    FooterComponent,
    RentalPropertyGridComponent,
    H2Component
  ],
  template: `
    <div class="bg-default min-h-screen flex flex-col gap-8">
      <div class="flex flex-col">
        <app-menubar></app-menubar>
        <div class="w-full">
          <img
            src="images/header.jpg"
            alt="Header Image"
            class="w-full h-[60vh] object-cover object-[75%]" />
          <app-search-bar />
        </div>
      </div>

      <div
        class="px-page sm:px-page md:px-page lg:px-page xl:px-page flex flex-col gap-8">
        <app-h2>Découvrez nos propriétés</app-h2>
        <app-rental-property-grid [properties]="properties" />
      </div>
      <app-footer></app-footer>
    </div>
  `
})
export class HomePage implements OnInit {
  private apiService = inject(ApiService);
  public properties: RentalPropertyInterface[] = [];
  ngOnInit(): void {
    firstValueFrom(
      this.apiService.rentalProperties(new RentalPropertyRequestDTO())
    ).then((response) => {
      this.properties = response.data;
    });
  }
}
