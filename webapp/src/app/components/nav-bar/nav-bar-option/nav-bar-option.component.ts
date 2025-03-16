import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-option',
  imports: [],
  template: `
    <a class="text-lg font-[Averia_Serif_Libre]">
      {{ text() }}
    </a>
  `
})
export class NavBarOptionComponent {
  text = input.required<string>();
}
