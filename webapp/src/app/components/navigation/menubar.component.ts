import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { LoginModalComponent } from '../login-modal/login-modal.component';
import { Component, inject } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { AuthService } from '../../services/auth.service';
import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-menubar',
  standalone: true,
  imports: [RouterModule, MenubarModule, CommonModule, ButtonModule],
  providers: [DialogService],
  template: `
    <p-menubar [model]="items" styleClass="bg-accent-2">
      <ng-template pTemplate="start">
        <a routerLink="/" class="text-logo text-white font-heading"
          >MONSÉJOUR</a
        >
      </ng-template>

      <ng-template #item let-item let-root="root">
        @if (item.routerLink) {
          <a [routerLink]="item.routerLink" class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
          </a>
        } @else if (item.url) {
          <a [href]="item.url" class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
          </a>
        } @else {
          <div class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
            @if (item.items) {
              <span class="pi pi-fw pi-angle-down ml-2"></span>
            }
          </div>
        }
      </ng-template>

      <ng-template pTemplate="end">
        @if (authService.getIsAuthenticated()) {
          <button (click)="authService.setAuthenticated(false)" class="text-menulink text-white bg-transparent border-none cursor-pointer p-0">
            Se déconnecter
          </button>
        } @else {
          <button (click)="showLoginModal()" class="text-menulink text-white bg-transparent border-none cursor-pointer p-0">
            Se connecter
          </button>
        }
      </ng-template>
    </p-menubar>
  `,
  styles: [
    `
      :host ::ng-deep .p-menubar {
        padding: 1.5rem var(--page-padding);
        background-color: var(--accent-1-color);
        border: none;
        border-radius: 0;
      }

      :host
        ::ng-deep
        .p-menubar-item:not(.p-disabled)
        > .p-menubar-item-content:hover {
        background: none;
      }
    `
  ]
})
export class MenubarComponent {
  private dialogService = inject(DialogService);
  private ref: DynamicDialogRef | undefined;
  public authService = inject(AuthService);

  showLoginModal() {
      this.ref = this.dialogService.open(LoginModalComponent, {
          width: '30rem',
          showHeader: false,
          contentStyle: {"max-height": "500px", "overflow": "auto"},
          breakpoints: {
              '960px': '75vw',
              '640px': '90vw'
          }
      });
  }
  items: MenuItem[] = [
    {
      label: 'À propos',
      routerLink: '/about'
    },
    {
      label: 'Contact',
      routerLink: '/contact'
    },
    {
      label: 'FAQ',
      routerLink: '/faq'
    }
  ];
}
