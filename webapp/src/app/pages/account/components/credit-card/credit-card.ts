import { Component, inject, input, OnInit, output } from '@angular/core';
import {
  CreditCardIcon,
  EditIcon,
  EyeIcon,
  EyeOffIcon,
  LucideAngularModule,
  PlusIcon,
  Trash2Icon
} from 'lucide-angular';
import { BillingInformation } from '../../../../interface/billing-information.interface';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';
import { ApiService } from '../../../../services/api.service';
import { CommonModule } from '@angular/common';
import { BillingInformationCreateDTO } from '../../../../dto/billing-information-create-dto';
import { BillingInformationUpdateDTO } from '../../../../dto/billing-information-update-dto';
import { firstValueFrom } from 'rxjs';
import { BillingInformationSetDefaultDTO } from '../../../../dto/billing-information-set-default-dto';
import { BillingInformationCreate } from '../../../../interface/billing-information-create.interface';
import { BillingInformationUpdate } from '../../../../interface/billing-information-update.interface';
import { BillingInformationService } from '../../../../services/billing-information.service';

@Component({
  selector: 'app-credit-card',
  standalone: true,
  imports: [LucideAngularModule, ReactiveFormsModule, CommonModule],
  template: `
    <div
      class="flex flex-col gap-8 border-1 border-[#9A9BA1] bg-[#CFD0D4]/50 p-8 max-w-[350px] rounded-lg shadow-[2px_2px_4px_rgba(0,0,0,0.1)]">
      @if (mode !== 'create-plus') {
        <div class="flex justify-between">
          @if (mode === 'create') {
            <span class="font-bold">Create</span>
          } @else if (mode === 'update') {
            <span class="font-bold">Update</span>
          } @else {
            <span class="font-bold">{{ cardType() }}</span>
          }
          <div class="flex gap-3">
            @if (mode === 'default') {
              <lucide-angular
                [img]="editIcon"
                class="cursor-pointer"
                (click)="startEditing()"></lucide-angular>
            }
            @if (mode !== 'create') {
              <lucide-angular
                [img]="trashIcon"
                class="cursor-pointer"
                (click)="showDeleteCardModal()"></lucide-angular>
            }
          </div>
        </div>
        <form [formGroup]="form" class="flex flex-col gap-2">
          <div class="flex gap-3 items-center">
            <lucide-angular [img]="creditCardIcon"></lucide-angular>
            @let cardNumber = card()?.cardNumber;
            @if (mode === 'create' || mode === 'update') {
              <input
                class="outline-none"
                placeholder="Card number"
                formControlName="cardNumber"
                maxlength="16" />
            } @else if (cardNumber) {
              <span class="font-mono tracking-thight">{{
                isVisible
                  ? billingInformationService.formatCardNumber(cardNumber)
                  : billingInformationService.maskCardNumber(cardNumber)
              }}</span>
              <lucide-angular
                [img]="isVisible ? eyeOffIcon : eyeIcon"
                class="cursor-pointer ml-2 w-5 h-5"
                (click)="toggleVisibility()">
              </lucide-angular>
            }
          </div>
          <div class="flex gap-3 items-center">
            @if (mode === 'create' || mode === 'update') {
              <div class="flex gap-1 items-center">
                <input
                  class="w-5 outline-none"
                  placeholder="M"
                  formControlName="monthExpiration"
                  maxlength="2" />
                <span>/</span>
                <input
                  class="w-5 outline-none"
                  placeholder="Y"
                  formControlName="yearExpiration"
                  maxlength="2" />
              </div>
            } @else {
              <span class="font-mono tracking-thight">
                {{ card()?.monthExpiration }}/{{ card()?.yearExpiration }}
              </span>
            }
          </div>
          @if (mode === 'create' || mode === 'update') {
            <div class="flex gap-4">
              @if (mode === 'update') {
                <div
                  class="bg-[#CFD0D4] rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2"
                  (click)="submitCreate()">
                  Confirmer
                </div>
                <div
                  class="bg-[#CFD0D4] rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2"
                  (click)="stopEditing()">
                  Annuler
                </div>
              } @else if (mode === 'create') {
                <div
                  class="bg-[#CFD0D4] rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2"
                  (click)="submitCreate()">
                  Confirmer
                </div>
                <div
                  class="bg-[#CFD0D4] rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2"
                  (click)="switchToCreatePlusMode()">
                  Annuler
                </div>
              }
            </div>
          } @else if (mode === 'update') {
            <div
              class="bg-[#CFD0D4] rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2"
              (click)="submitUpdate()">
              Mettre à jour
            </div>
          } @else {
            @if (card()?.isDefault) {
              <div [class]="getButtonClassName()">Par default</div>
            } @else {
              <div [class]="getButtonClassName()" (click)="setDefaultCard()">
                Choisir par default
              </div>
            }
          }
        </form>
      } @else {
        <div class="flex justify-center items-center h-[156px]">
          <lucide-angular
            [img]="plusIcon"
            class="cursor-pointer w-16 h-16 text-[#9A9BA1]"
            (click)="switchToCreateMode()"></lucide-angular>
        </div>
      }
    </div>
  `
})
export class CreditCardComponent implements OnInit {
  public card = input<BillingInformation>();
  public cardType = input<string>();
  public type = input<string>('default');
  public onChange = output<void>();
  public mode: string = 'default';

  public creditCardIcon = CreditCardIcon;
  public trashIcon = Trash2Icon;
  public eyeIcon = EyeIcon;
  public eyeOffIcon = EyeOffIcon;
  public editIcon = EditIcon;
  public plusIcon = PlusIcon;

  fb = inject(FormBuilder);
  apiService = inject(ApiService);
  billingInformationService = inject(BillingInformationService);

  ngOnInit(): void {
    if (this.card()?.cardNumber === undefined) {
      console.log(this.type(), this.mode, this.card()?.cardNumber);
    }
    this.mode = this.type();
    this.setUpForm();
  }

  public showDeleteCardModal() {}

  public getButtonClassName() {
    const baseClass =
      'rounded-lg px-2 py-[2px] inline-block w-fit cursor-pointer mt-2';
    if (this.card()?.isDefault) {
      return baseClass + ' ' + 'bg-[#A94A4A]/60';
    }
    return baseClass + ' ' + 'bg-[#CFD0D4]';
  }

  private setUpForm() {
    this.form.controls.cardNumber.setValue(this.card()?.cardNumber ?? '');
    this.form.controls.monthExpiration.setValue(
      this.card()?.monthExpiration.toString() ?? ''
    );
    this.form.controls.yearExpiration.setValue(
      this.card()?.yearExpiration.toString() ?? ''
    );
  }

  public startEditing() {
    this.mode = 'update';
  }

  public stopEditing() {
    this.mode = 'default';
    this.setUpForm();
  }

  public isVisible = false;
  public toggleVisibility() {
    this.isVisible = !this.isVisible;
  }

  form = this.fb.group({
    cardNumber: [
      '',
      [
        Validators.required,
        Validators.pattern(/^\d{15,16}$/),
        Validators.minLength(15),
        Validators.maxLength(16)
      ]
    ],
    monthExpiration: [
      '',
      [Validators.required, Validators.min(1), Validators.max(12)]
    ],
    yearExpiration: [
      '',
      [
        Validators.required,
        Validators.min(new Date().getFullYear() % 100),
        Validators.pattern(/^\d{2}$/)
      ]
    ]
  });

  public setDefaultCard() {
    const id = this.card()?.id;
    if (id) {
      firstValueFrom(
        this.apiService.setDefaultCard(new BillingInformationSetDefaultDTO(id))
      ).then(() => {
        this.onChange.emit();
      });
    }
  }

  public async submitCreate() {
    if (this.form.invalid) {
      return;
    }

    firstValueFrom(
      this.apiService.createBillingInformation(
        BillingInformationCreateDTO.fromInterface(
          this.form.getRawValue() as BillingInformationCreate
        )
      )
    ).then(() => {
      this.onChange.emit();
    });
  }

  public async submitUpdate() {
    if (this.form.invalid) {
      return;
    }

    firstValueFrom(
      this.apiService.updateBillingInformation(
        BillingInformationUpdateDTO.fromInterface(
          this.form.getRawValue() as BillingInformationUpdate
        )
      )
    ).then(() => {
      this.onChange.emit();
    });
  }

  public switchToCreatePlusMode() {
    this.mode = 'create-plus';
    this.form.reset();
  }

  public switchToCreateMode() {
    this.mode = 'create';
  }
}
