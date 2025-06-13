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
      <ng-template #start>
        <a
          routerLink="/"
          id="menu-logo"
          class="text-white text-lg font-bold font-averia"
          >MONSÉJOUR</a
        >
      </ng-template>

      <ng-template #item let-item let-root="root">
        <a [routerLink]="item.routerLink" class="p-menubar-item-link">
          <span class="font-averia">{{ item.label }}</span>
        </a>
      </ng-template>

      <ng-template #end>
        @if (authService.getIsAuthenticated()) {
          <button
            id="menu-logout"
            (click)="authService.setAuthenticated(false)"
            class="text-white text-lg font-averia cursor-pointer">
            Se déconnecter
          </button>
        } @else {
          <button
            id="menu-login"
            (click)="showLoginModal()"
            class="text-white text-lg font-averia cursor-pointer">
            Se connecter
          </button>
        }
      </ng-template>
    </p-menubar>
  `,
  styles: `
    :host ::ng-deep .p-menubar {
      padding: 1.5rem var(--page-padding);
      background-color: var(--accent-1-color);
      border: none;
      border-radius: 0;
    }

    :host ::ng-deep .p-menubar-item-link {
      color: white;
      font-size: 1.125rem;
    }

    @media (max-width: 960px) {
      :host ::ng-deep .p-menubar-item-link {
        color: black;
      }
    }

    @media (min-width: 961px) {
      :host ::ng-deep .p-menubar-item-link,
      #menu-logo,
      #menu-logout,
      #menu-login {
        font-size: 1.5rem;
      }

      :host ::ng-deep #menu-logo {
        margin-right: 48px;
      }
    }

    @media (min-width: 640px) {
      :host ::ng-deep .p-menubar {
        padding: 1.5rem var(--sm-page-padding);
      }
    }

    @media (min-width: 768px) {
      :host ::ng-deep .p-menubar {
        padding: 1.5rem var(--md-page-padding);
      }
    }

    @media (min-width: 1024px) {
      :host ::ng-deep .p-menubar {
        padding: 1.5rem var(--lg-page-padding);
      }
    }

    @media (min-width: 1280px) {
      :host ::ng-deep .p-menubar {
        padding: 1.5rem var(--xl-page-padding);
      }

      :host ::ng-deep .p-menubar-item-link,
      #menu-logo,
      #menu-logout,
      #menu-login {
        font-size: 32px;
      }
    }

    :host
      ::ng-deep
      .p-menubar-item:not(.p-disabled)
      > .p-menubar-item-content:hover {
      background: none;
    }
  `
})
export class MenubarComponent {
  private dialogService = inject(DialogService);
  private ref: DynamicDialogRef | undefined;
  public authService = inject(AuthService);

  showLoginModal() {
    this.ref = this.dialogService.open(LoginModalComponent, {
      width: '30rem',
      showHeader: false,
      contentStyle: { 'max-height': '500px', overflow: 'auto' },
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw'
      }
    });
  }
  private _items: MenuItem[] = [
    {
      label: 'Contact',
      routerLink: '/contact'
    },
    {
      label: 'FAQ',
      routerLink: '/faq'
    }
  ];

  private _authItems: MenuItem[] = [
    {
      label: 'Profile',
      routerLink: '/profile'
    },
    {
      label: 'Reservations',
      routerLink: '/reservations'
    },
    {
      label: 'Contact',
      routerLink: '/contact'
    },
    {
      label: 'FAQ',
      routerLink: '/faq'
    }
  ]

  public get items() {
    if (this.authService.getIsAuthenticated()) return this._authItems;
    return this._items;
  }
}
