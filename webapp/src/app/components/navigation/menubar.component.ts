import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MenuItem } from 'primeng/api';
import { MenubarModule } from 'primeng/menubar';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-menubar',
  standalone: true,
  imports: [RouterModule, MenubarModule, CommonModule],
  template: `
    <p-menubar [model]="items" styleClass="bg-accent-2">
      <ng-template pTemplate="start">
        <a routerLink="/" class="text-logo text-white font-heading"
          >MONSÉJOUR</a
        >
      </ng-template>

      <ng-template #item let-item>
        <ng-container *ngIf="item.routerLink; else urlRef">
          <a [routerLink]="item.routerLink" class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
          </a>
        </ng-container>
        <ng-template #urlRef>
          <a
            *ngIf="item.url; else noLink"
            [href]="item.url"
            class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
          </a>
        </ng-template>
        <ng-template #noLink>
          <div class="p-menubar-item-link">
            <span class="text-menulink text-white">{{ item.label }}</span>
            <span class="pi pi-fw pi-angle-down ml-2"></span>
          </div>
        </ng-template>
      </ng-template>

      <ng-template pTemplate="end">
        <a routerLink="/login" class="text-menulink text-white">
          Se connecter
        </a>
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
  items: MenuItem[] = [
    {
      label: 'Á propos',
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
