import { Component, inject } from '@angular/core';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { H3Component } from '../../components/typography/h3.component';
// Removed: import { CustomInputComponent } from '../../components/custom-input.component';
// Removed: import { CustomTextareaComponent } from '../../components/custom-textarea.component';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ThreeDButtonComponent } from '../../components/three-d-button/three-d-button.component';
import { ApiService } from '../../services/api.service';
import { ContactRequestDTO } from '../../dtos/contact-request.dto';
import { firstValueFrom } from 'rxjs';
import { CustomInputDirective } from '../../directives/custom-input.directive';
import { CustomTextareaDirective } from '../../directives/custom-textarea.directive'; // Added

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [
    MenubarComponent,
    H3Component,
    FormsModule,
    ReactiveFormsModule,
    CustomInputDirective,
    CustomTextareaDirective,
    ThreeDButtonComponent
  ],
  template: `
    <div class="">
      <app-menubar></app-menubar>
      <div
        class="gap-8 px-page sm:px-page md:px-page lg:px-page xl:px-page pt-8 lg:pt-16">
        <div class="mx-auto max-w-[580px] lg:mx-0 lg:w-[390px]">
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
            <form [formGroup]="contactForm" (ngSubmit)="send()" class="flex flex-col gap-6">
              <div class="flex flex-col gap-3">
                <input type="email" formControlName="email" appCustomInput="Email" />
                <input type="text" formControlName="subject" appCustomInput="Subject" />
              </div>
              <textarea formControlName="message" appCustomTextarea="Message"></textarea>
              <app-three-d-button type="submit">Submit</app-three-d-button>
            </form>
          </div>
        </div>
      </div>
      <img
        src="images/contact_page_side_img.jpg"
        alt="Contact Image"
        class="w-full object-cover hidden lg:block lg:absolute lg:top-[calc(112px+64px)] lg:w-[calc(100vw-64px-64px-390px-64px)] lg:left-[calc(390px+64px+64px)] lg:h-[calc(100vh-112px-64px-64px)] lg:rounded-[8px]" />
    </div>
  `
})
export class ContactPage {

  public fb = inject(FormBuilder);
  public apiService = inject(ApiService);

  contactForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    subject: ['', Validators.required],
    message: ['', Validators.required]
  });

  public send() {
    if (this.contactForm.valid) {
      const form = this.contactForm.getRawValue();
      firstValueFrom(this.apiService.sendContactRequest(new ContactRequestDTO(form.email!, form.subject!, form.message!)))
        .then((res) => {
          this.contactForm.reset();
        })
        .catch(err => {
          console.error(err);
        });
    } else {
      this.contactForm.markAllAsTouched();
    }
  }
}
