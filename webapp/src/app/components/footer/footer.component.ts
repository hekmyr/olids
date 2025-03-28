import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { APP_TITLE } from '../../constant';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  template: `
    <footer class="bg-alternative px-page py-8">
      <div class="flex justify-between items-start">
        <div class="text-[96px] font-heading">{{ appTitle }}</div>
        <div>
          <ul class="flex flex-col gap-2">
            <li><a href="#" class="text-footer-link">Link 1</a></li>
            <li><a href="#" class="text-footer-link">Link 2</a></li>
            <li><a href="#" class="text-footer-link">Link 3</a></li>
          </ul>
        </div>
        <div class="ml-32">
          <ul class="flex flex-col gap-2">
            <li><a href="#" class="text-footer-link">Link 4</a></li>
            <li><a href="#" class="text-footer-link">Link 5</a></li>
            <li><a href="#" class="text-footer-link">Link 6</a></li>
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
