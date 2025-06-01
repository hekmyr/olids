import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchBarComponent } from '../search/search-bar.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, SearchBarComponent],
  template: `
    <div class="w-full">
      <img src="images/header.jpg" alt="Header Image" class="w-full" />
      <app-search-bar />
    </div>
  `,
  styles: ``
})
export class HeaderComponent {}
