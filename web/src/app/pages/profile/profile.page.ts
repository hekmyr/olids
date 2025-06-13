import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { Heading2Directive } from '../../directives/heading2.directive';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { InputDirective } from '../../directives/custom-input.directive';
import { ButtonDirective } from '../../directives/custom-button.directive';
import { UserUpdateDTO } from '../../dtos/user-update.dto';

@Component({
  selector: 'app-profile',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    Heading2Directive,
    MenubarComponent,
    InputDirective,
    ButtonDirective
  ],
  template: `
  <app-menubar />
  <div class="min-h-screen bg-background py-8">
    <div class="max-w-4xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="mb-8">
        <h2 heading2 ="text-3xl font-bold text-gray-900 text-shadow">Mon profile</h2>
        <p class="mt-2 text-gray-600">Modifier les informations utilisateurs</p>
      </div>

      <div class="bg-white rounded-lg shadow-md overflow-hidden">
        <form [formGroup]="profileForm" (ngSubmit)="onSubmit()" class="p-6 sm:p-8">
          <div class="grid grid-cols-1 md:grid-cols-2 gap-6">
            <div>
              <label for="name" class="font-medium text-sm">
                Nom
              </label>
              <input
                type="text"
                id="name"
                formControlName="name"
                inputStyle
                [class.border-red-500]="isFieldInvalid('name')"
              />
              <div *ngIf="isFieldInvalid('firstName')" class="mt-1 text-sm text-red-600">
                Nom requis
              </div>
            </div>

            <div>
              <label for="phone" class="font-medium text-sm">
                Telephone
              </label>
              <input
                type="tel"
                id="phone"
                formControlName="phone"
                inputStyle
                [class.border-red-500]="isFieldInvalid('phone')"
              />
              <div *ngIf="isFieldInvalid('phone')" class="mt-1 text-sm text-red-600">
                <span *ngIf="profileForm.get('phone')?.errors?.['pattern']">Valeur invalide</span>
              </div>
            </div>


            <div>
              <label for="street" class="font-medium text-sm">
                Rue
              </label>
              <input
                type="text"
                id="street"
                formControlName="street"
                inputStyle
                [class.border-red-500]="isFieldInvalid('street')"
              />
            </div>


            <div class="">
              <label for="zip" class="font-medium text-sm">
                Code postal
              </label>
              <input
                type="text"
                id="zip"
                formControlName="zip"
                inputStyle
                [class.border-red-500]="isFieldInvalid('zip')"
              />
            </div>
          </div>

          <div class="mt-8 flex justify-end">
            <button
              buttonStyle="3d"
              type="submit"
              class="w-full sm:w-fit"
              [disabled]="profileForm.invalid"
            >
              Save Changes
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
  `
})
export class ProfilePage implements OnInit {
  private apiService = inject(ApiService);
  private fb = inject(FormBuilder);

  ngOnInit(): void {
    firstValueFrom(this.apiService.getUser())
      .then(res => {
        this.profileForm.controls.name.setValue(res.data.name);
        this.profileForm.controls.phone.setValue(res.data.phone);
        this.profileForm.controls.street.setValue(res.data.street);
        this.profileForm.controls.zip.setValue(res.data.zip);
      })
      .catch(err => console.log(err));
  }

  public profileForm = this.fb.group({
    name: ['', [Validators.required, Validators.minLength(2)]],
    phone: [''],
    street: [''],
    zip: [''],
  });

  onSubmit() {

    console.log(this.profileForm.value.phone)
    if (!this.profileForm.valid) return

    const values = this.profileForm.getRawValue();

    if (!values.name) return;

    firstValueFrom(this.apiService.updateUser(new UserUpdateDTO(
      values.name,
      values.phone,
      values.street,
      values.zip
    )))
      .catch((err) => console.log(err))
  }

  isFieldInvalid(fieldName: string): boolean {
    const field = this.profileForm.get(fieldName);
    return !!(field && field.invalid && (field.dirty || field.touched));
  }
}
