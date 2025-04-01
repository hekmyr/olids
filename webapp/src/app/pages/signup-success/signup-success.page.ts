import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenubarComponent } from '../../components/navigation/menubar.component';
import { LucideAngularModule, CheckCircle } from 'lucide-angular';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-signup-success-page',
  standalone: true,
  imports: [CommonModule, MenubarComponent, LucideAngularModule, RouterLink],
  template: `
    <div class="h-screen">
      <app-menubar class="h-full"></app-menubar>
      <div class="flex justify-center items-center flex-col gap-4 mt-16">
        <lucide-icon [name]="CheckCircle" color="green" size="48"></lucide-icon>
        <h1 class="text-4xl font-bold">Inscription avec succès!</h1>
        <a routerLink="/" class="bg-accent-1 text-white py-2 px-4 rounded-md"
          >Retour</a
        >
      </div>
    </div>
  `,
  styles: ``
})
export class SignupSuccessPage {
  CheckCircle = CheckCircle;
}
