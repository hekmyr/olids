import { Component, inject, input } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { ApiService } from '../../../../services/api.service';
import { UserUpdateModel } from '../../../../models/user-update.model';
import { InputComponent } from '../../../../components/input/input.component';
import { Button3dComponent } from '../../../../components/button-3d/button-3d.component';
import { User } from '../../../../interfaces/user.interface';
@Component({
  selector: 'app-profile-form',
  imports: [ReactiveFormsModule, InputComponent, Button3dComponent],
  template: `
    <div class="flex flex-col gap-8">
      <div class="flex gap-[60px]">
        <div class="flex flex-col gap-3">
          <h3 class="text-2xl font-[Averia_Serif_Libre] font-bold">
            Information personnelles
          </h3>
          <div class="flex gap-[40px]">
            <app-input
              class="w-[220px]"
              label="Nom"
              (value)="this.form.controls.lastName.setValue($event)" />
            <app-input
              class="w-[220px]"
              label="Prénom"
              (value)="this.form.controls.firstName.setValue($event)" />
          </div>
          <div class="flex gap-[40px]">
            <app-input
              class="w-[220px]"
              label="Date de naissance"
              (value)="this.form.controls.birthDate.setValue($event)" />
            <app-input
              class="w-[220px]"
              label="Numéro de téléphone"
              (value)="this.form.controls.phoneNumber.setValue($event)" />
          </div>
        </div>
        <div class="flex flex-col gap-3">
          <h3 class="text-2xl font-[Averia_Serif_Libre] font-bold">Adresse</h3>
          <div class="flex gap-[40px]">
            <app-input
              class="w-[220px]"
              label="Pays"
              (value)="this.form.controls.country.setValue($event)" />
            <app-input
              class="w-[220px]"
              label="Rue"
              (value)="this.form.controls.street.setValue($event)" />
          </div>
          <div class="flex gap-[40px]">
            <app-input
              class="w-[220px]"
              label="Numéro"
              (value)="this.form.controls.number.setValue($event)" />
            <app-input
              class="w-[220px]"
              label="Code postal"
              (value)="this.form.controls.postalCode.setValue($event)" />
          </div>
        </div>
      </div>
      <app-button-3d text="Envoyer" (click)="submit()" />
    </div>
  `
})
export class ProfileFormComponent {
  public user = input.required<User | null>();
  private fb = inject(FormBuilder);
  public form = this.fb.group({
    firstName: [''],
    lastName: [''],
    birthDate: [''],
    phoneNumber: [''],
    country: [''],
    street: [''],
    number: [''],
    postalCode: ['']
  });

  logging(e: any) {}

  apiService = inject(ApiService);
  submit() {
    const updateDTO = new UserUpdateModel(
      this.form.controls.lastName.value,
      this.form.controls.firstName.value,
      this.form.controls.phoneNumber.value,
      this.form.controls.street.value,
      this.form.controls.number.value,
      this.form.controls.postalCode.value,
      this.form.controls.birthDate.value
        ? new Date(this.form.controls.birthDate.value)
        : null
    );
    console.log(updateDTO);
    this.apiService.updateUser(updateDTO);
  }
}
