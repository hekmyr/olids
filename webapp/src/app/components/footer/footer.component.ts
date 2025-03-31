import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { APP_TITLE } from '../../constant';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  template: `
    <footer class="bg-alternative px-page sm:px-page md:px-page lg:px-page xl:px-page py-3 sm:py-6 lg:py-12">
      <div class="flex justify-between items-start">
        <a href="/" class="text-[24px] sm:text-[48px] md:text-[64px] lg:text-[80px] xl:text-[96px] font-heading">{{ appTitle }}</a>
        <!-- <div>
          <ul class="flex flex-col gap-2">
            <li><a href="#" class="text-footer-link">Profile</a></li>
            <li><a href="#" class="text-footer-link">Réservations</a></li>
            <li><a href="#" class="text-footer-link">Link 6</a></li>
          </ul>
        </div> -->
        <div>
        <!-- class="ml-32" -->
          <ul class="flex flex-col gap-2">
            <li><a href="#" class="text-sm sm:text-lg md:text-xl lg:text-2xl xl:text-3xl font-averia">À propos</a></li>
            <li><a href="#" class="text-sm sm:text-lg md:text-xl lg:text-2xl xl:text-3xl font-averia">Contactez-nous</a></li>
            <li><a href="#" class="text-sm sm:text-lg md:text-xl lg:text-2xl xl:text-3xl font-averia">FAQ</a></li>
          </ul>
        </div>
      </div>
    </footer>
  `,
  styles: ``
})
export class FooterComponent {
  appTitle = APP_TITLE;
}
