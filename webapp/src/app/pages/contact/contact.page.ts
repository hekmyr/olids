import { Component, inject } from '@angular/core';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { H3Component } from '../../components/typography/h3.component';
import { CustomInputComponent } from '../../components/custom-input.component';
import { CustomTextareaComponent } from '../../components/custom-textarea.component';
import { FormsModule } from '@angular/forms';
import { ThreeDButtonComponent } from '../../components/three-d-button/three-d-button.component';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    MenubarComponent,
    H3Component,
    FormsModule,
    CustomInputComponent,
    CustomTextareaComponent,
    ThreeDButtonComponent
  ],
  template: `
    <div class="min-h-screen">
      <app-menubar></app-menubar>
      <div class="px-page pt-page pb-page flex gap-16">
        <div class="flex flex-col gap-8 min-w-[480px]">
          <div class="flex flex-col gap-4">
            <app-h3>Coordonnées</app-h3>
            <div class="flex flex-col gap-3">
              <div class="flex justify-between">
                <span class="font-semibold">Adresse</span>
                <span>Hadikgasse 96<br />1140 Wien</span>
              </div>
              <div class="flex justify-between">
                <span class="font-semibold">Email</span>
                <span>misael.mcdermott&#64;monsejour.at</span>
              </div>
              <div class="flex justify-between">
                <span class="font-semibold">Numéro de téléphone</span>
                <span>+(43) (01) 8121287</span>
              </div>
            </div>
          </div>
          <div class="flex flex-col gap-4">
            <app-h3>Nous contacter</app-h3>
            <form class="flex flex-col gap-6">
              <div class="flex flex-col gap-3">
                <app-custom-input placeholder="Email"> </app-custom-input>
                <app-custom-input placeholder="Subject"> </app-custom-input>
              </div>
              <app-custom-textarea placeholder="Message"> </app-custom-textarea>
              <app-three-d-button>Submit</app-three-d-button>
            </form>
          </div>
        </div>
        <img
          src="images/contact_page_side_img.jpg"
          alt="Contact Image"
          class="flex h-[calc(100vh-228px)] w-full object-cover rounded-md" />
      </div>
    </div>
  `
})
export class ContactPage {}
