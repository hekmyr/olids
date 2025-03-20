import { Component, input } from '@angular/core';
import { SidebarButtonComponent } from './sidebar-button/sidebar-button.component';
import { Activity, Calendar, User } from 'lucide-angular';

interface SidebarItem {
  icon: any;
  code: string;
  text: string;
  link: string;
}

@Component({
  selector: 'app-sidebar',
  imports: [SidebarButtonComponent],
  template: `
    <div
      class="flex flex-col gap-[18px] px-4 pt-[18px] w-[300px] bg-[#CFD0D4] bg-opacity-50 min-h-full">
      <h2 class="font-[Averia_Serif_Libre] text-2xl">Dashboard</h2>
      <div class="flex flex-col gap-3">
        @for (item of sidebarItems; track $index) {
          <app-sidebar-button
            [icon]="item.icon"
            [text]="item.text"
            [link]="item.link"
            [isActivated]="item.code == activated()" />
        }
      </div>
    </div>
  `
})
export class SidebarComponent {
  activated = input<string | null>(null);
  sidebarItems: Array<SidebarItem> = [
    {
      icon: User,
      code: 'profile',
      text: 'Profile',
      link: '/dashboard/profile'
    },
    {
      icon: Calendar,
      code: 'reservations',
      text: 'Reservations',
      link: '/dashboard/reservations'
    },
    {
      icon: Activity,
      code: 'sessions',
      text: 'Sessions actives',
      link: '/dashboard/sessions'
    }
  ];
}
