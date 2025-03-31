import { Component, inject, Output, EventEmitter, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { FormsModule, ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { DynamicDialogRef } from 'primeng/dynamicdialog';
import { MessageService } from 'primeng/api';
import { ToastComponent } from '../toast/toast.component';
import { AuthService } from '../../services/auth.service';
import { SignInDTO } from '../../dtos/sign-in.dto';
import { ToastModule } from 'primeng/toast';
import { input, output } from '@angular/core';
import { TabViewModule } from 'primeng/tabview';
import { SignUpDTO } from '../../dtos/sign-up.dto';
import { ApiService } from '../../services/api.service';
import { firstValueFrom } from 'rxjs';
import { PrimaryButtonComponent } from '../primary-button/primary-button.component';
import { LucideAngularModule } from 'lucide-angular';
import { SecondaryButtonComponent } from '../secondary-button/secondary-button.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-modal',
  standalone: true,
  imports: [
    CommonModule,
    LucideAngularModule,
    InputTextModule,
    FormsModule,
    ReactiveFormsModule,
    TabViewModule,
    PrimaryButtonComponent,
    SecondaryButtonComponent
  ],
  template: `
      <p-tabView>
        <p-tabPanel header="Se connecter">
          <form [formGroup]="loginForm" (ngSubmit)="onSignInSubmit()" class="flex flex-col gap-8 mt-4">
          <div class="flex flex-col gap-2">
            <div class="flex flex-col gap-2">
              <label for="email">Email</label>
              <input pInputText id="email" type="email" formControlName="email" />
              @if (loginForm.controls.email.invalid && loginForm.controls.email.touched) {
                @if (loginForm.controls.email.errors?.['required']) {
                  <span class="text-sm text-red-500">Email is required.</span>
                }
                @if (loginForm.controls.email.errors?.['email']) {
                  <span class="text-sm text-red-500">Must be a valid email address.</span>
                }
              }
            </div>
            <div class="flex flex-col gap-2">
              <label for="password">Password</label>
              <input pInputText id="password" type="password" formControlName="password" />
              @if (loginForm.controls.password.invalid && loginForm.controls.password.touched) {
                @if (loginForm.controls.password.errors?.['required']) {
                  <span class="text-sm text-red-500">Password is required.</span>
                }
              }
            </div>
          </div>
          @if (signInError()) {
            <span class="text-sm text-red-500">Adresse e-mail ou mot de passe incorrect.</span>
          }
            <div class="flex gap-4">
              <app-primary-button type="submit">Se connecter</app-primary-button>
              <app-secondary-button (click)="onClose()">Fermer</app-secondary-button>
            </div>
          </form>
        </p-tabPanel>
        <p-tabPanel header="S'inscrire">
          <form [formGroup]="signUpForm" (ngSubmit)="onSignUpSubmit()" class="flex flex-col gap-8 mt-4">
            <div class="flex flex-col gap-2">
              <div class="flex flex-col gap-2">
              <label for="signUpEmail">Email</label>
              <input pInputText id="signUpEmail" type="email" formControlName="email" />
              @if (signUpForm.controls.email.invalid && signUpForm.controls.email.touched) {
                @if (signUpForm.controls.email.errors?.['required']) {
                  <span class="text-sm text-red-500">Email is required.</span>
                }
                @if (signUpForm.controls.email.errors?.['email']) {
                  <span class="text-sm text-red-500">Must be a valid email address.</span>
                }
              }
              </div>
              <div class="flex flex-col gap-2">
              <label for="signUpPassword">Password</label>
              <input pInputText id="signUpPassword" type="password" formControlName="password" />
              @if (signUpForm.controls.password.invalid &&  signUpForm.controls.password.touched) {
                @if (signUpForm.controls.password.errors?.['required']) {
                  <span class="text-sm text-red-500">Password is required.</span>
                }
              }
              </div>
            </div>
            @if (signUpError()) {
              <span class="text-sm text-red-500">L'inscription a échoué. Veuillez réessayer.</span>
            }
              <div class="flex gap-4">
              <app-primary-button type="submit">S'inscrire</app-primary-button>
              <app-secondary-button (click)="onClose()">Fermer</app-secondary-button>
              </div>
            </form>
        </p-tabPanel>
      </p-tabView>
  `,
  styles: `
    :host ::ng-deep .p-tab {
      color: var(--disabled);
    }
    :host ::ng-deep .p-tab-active {
      color: var(--accent-2-color);
      border-color: var(--accent-2-color);
    }
    
    :host ::ng-deep .p-tablist-active-bar {
      background-color: var(--accent-2-color);
    }
    
    :host ::ng-deep .p-inputtext:enabled:focus {
      border-color: var(--accent-1-color);
    }
  `,
  providers: [MessageService]
})
export class LoginModalComponent {
  private fb = inject(FormBuilder);
  private ref = inject(DynamicDialogRef);
  private authService = inject(AuthService);
  private apiService = inject(ApiService);
  private router = inject(Router);
  
  public signUpClicked = output<void>();

  loginForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });

  signUpForm = this.fb.group({
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required]
  });
  
  signInError = signal<boolean>(false);
  signUpError = signal<boolean>(false);

  public onSignInSubmit() {
    if (!this.loginForm.valid) {
      this.loginForm.markAllAsTouched();
      return;
    }
    const signInDto = new SignInDTO(
      this.loginForm.value.email ?? '',
      this.loginForm.value.password ?? ''
    );
    this.authService.signIn(signInDto)
      .then(() => {
        this.ref.close(true);
      })
      .catch(() => {
        this.signInError.set(true);
      });
  }
  
  public onSignUpSubmit() {
    if (!this.signUpForm.valid) {
      this.signUpForm.markAllAsTouched();
      return;
    }
    
    const signUpDto = new SignUpDTO(
      this.signUpForm.controls.email.value ?? '',
      this.signUpForm.controls.password.value ?? ''
    );
    
    firstValueFrom(this.apiService.signUp(signUpDto))
      .then(() => {
        this.router.navigate(['/signup-success']);
        this.ref.close();
      })
      .catch((error) => {
        console.error('Signup failed', error);
        this.signUpError.set(true);
      });
  }

  public onClose(): void {
    this.ref.close();
  }
}