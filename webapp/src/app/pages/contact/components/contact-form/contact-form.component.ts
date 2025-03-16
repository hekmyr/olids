import { Component, inject } from '@angular/core';
import { Button3dComponent } from '../../../../components/button-3d/button-3d.component';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ContactRequestDTO } from '../../../../dto/contact-request.dto';
import { ApiService } from '../../../../services/api.service';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-contact-form',
  imports: [Button3dComponent, ReactiveFormsModule],
  template: `
    <div class="flex flex-col gap-8">
      <h2 class="text-7xl font-[Averia_Serif_Libre] font-bold">
        Nous contacter
      </h2>
      <div class="flex flex-col gap-6">
        <form
          [formGroup]="contactForm"
          (ngSubmit)="onSubmit()"
          class="flex flex-col gap-3">
          <input
            class="outline-none text-2xl"
            placeholder="Adresse électronique"
            formControlName="email" />
          <input
            class="outline-none text-2xl"
            placeholder="Sujet"
            formControlName="subject" />
          <textarea
            class="outline-none text-2xl resize-none border-2 border-[#9a9ba1] bg-[#cfd0d4]/50 p-2 rounded"
            rows="4"
            placeholder="Message"
            formControlName="message"></textarea>
          <div class="flex justify-end">
            <app-button-3d
              class="w-[120px]"
              text="Envoyer"
              type="submit"
              [disabled]="!contactForm.valid" />
          </div>
        </form>
      </div>
    </div>
  `
})
export class ContactFormComponent {
  private fb = inject(FormBuilder);
  private apiService = inject(ApiService);

  contactForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    subject: ['', Validators.required],
    message: ['']
  });

  onSubmit(): void {
    const email = this.contactForm.controls.email.value;
    const subject = this.contactForm.controls.subject.value;
    const message = this.contactForm.controls.message.value;
    if (this.contactForm.valid && email && subject) {
      const request = new ContactRequestDTO(email, subject, message);

      firstValueFrom(this.apiService.sendContactRequest(request))
        .then((response) => this.contactForm.reset())
        .catch((error) => {});
    }
  }
}
