import { Component } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { PropertyCollectionComponent } from './components/property-collection/property-collection.component';

@Component({
  selector: 'app-properties',
  imports: [NavBarComponent, PropertyCollectionComponent],
  template: `
    <div class="bg-default h-full min-h-svh">
      <app-nav-bar />
      <div class="mx-12">
        <h1 class="text-9xl">Toutes nos propriétés</h1>
        <app-property-collection />
      </div>
    </div>
  `
})
export class RentalPropertiesPage {}
