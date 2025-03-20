import { Component, inject, input } from '@angular/core';
import { Router } from '@angular/router';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-sidebar-button',
  imports: [LucideAngularModule],
  template: `
    <div [class]="getClassString()" (click)="navigateTo()">
      <lucide-angular [img]="icon()"></lucide-angular>
      <span>
        {{ text() }}
      </span>
    </div>
  `
})
export class SidebarButtonComponent {
  public text = input.required<string>();
  public icon = input.required<any>();
  public link = input<string | null>(null);
  public isActivated = input<boolean>(false);

  private router = inject(Router);

  getClassString(): string {
    const baseClasses =
      'w-full flex gap-[18px] rounded-lg text-lg p-2 cursor-pointer transition-colors';

    if (this.isActivated()) {
      return `${baseClasses} bg-[#A94A4A] text-white`;
    } else {
      return `${baseClasses} hover:bg-[#B21212]/40`;
    }
  }

  navigateTo() {
    if (this.link() === null) return;
    const route = this.link();
    if (route) {
      this.router.navigateByUrl(route);
    }
  }
}
