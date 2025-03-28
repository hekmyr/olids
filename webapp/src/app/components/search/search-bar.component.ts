import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-bar',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="px-page py-4 bg-white">
      <div class="flex items-center">
        <input
          type="text"
          class="w-full text-black outline-none text-2xl"
          placeholder="Search"
          [(ngModel)]="searchTerm" />
      </div>
    </div>
  `
})
export class SearchBarComponent {
  searchTerm: string = '';
}
