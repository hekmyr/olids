import { Component } from '@angular/core';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { ContactFormComponent } from './components/contact-form/contact-form.component';
import {
  ADDRESS_STREET,
  ADDRESS_REGION,
  EMAIL,
  PHONE_NUMBER,
  CONTACT_PAGE_IMAGE
} from '../../constant';

@Component({
  selector: 'app-contact',
  imports: [NavBarComponent, ContactFormComponent],
  template: `
    <div class="h-svh">
      <div class="h-full grid grid-cols-[auto_900px] grid-rows-[auto_1fr]">
        <app-nav-bar class="col-span-2" />
        <img class="h-full w-full object-cover" [src]="contactPageImage" />
        <div>
          <div class="flex flex-col gap-30 mt-24 w-[600px] mx-auto">
            <div class="flex flex-col gap-8">
              <h2 class="text-7xl font-[Averia_Serif_Libre] font-bold">
                Coordonnées
              </h2>
              <div class="flex flex-col gap-6">
                <div class="flex justify-between">
                  <span class="text-xl font-bold">Adresse</span>
                  <div class="flex flex-col">
                    <span class="text-xl text-right">{{ addressStreet }}</span
                    ><span class="text-xl text-right">
                      {{ addressRegion }}</span
                    >
                  </div>
                </div>
                <div class="flex justify-between">
                  <span class="text-xl font-bold">Email</span>
                  <span class="text-xl">{{ email }}</span>
                </div>
                <div class="flex justify-between">
                  <span class="text-xl font-bold">Téléphone</span>
                  <span class="text-xl">{{ phoneNumber }}</span>
                </div>
              </div>
            </div>
            <app-contact-form />
          </div>
        </div>
      </div>
    </div>
  `
})
export class ContactPage {
  addressStreet = ADDRESS_STREET;
  addressRegion = ADDRESS_REGION;
  email = EMAIL;
  phoneNumber = PHONE_NUMBER;
  contactPageImage = CONTACT_PAGE_IMAGE;
}
