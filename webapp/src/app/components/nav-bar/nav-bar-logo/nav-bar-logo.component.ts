import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-logo',
  imports: [RouterLink],
  template: `
    <a
      class="text-lg font-[Averia_Serif_Libre] font-bold"
      routerLink="{{ link() }}">
      {{ text() }}
    </a>
  `
})
export class NavBarLogoComponent {
  text = input.required<string>();
  link = input.required<string>();
}
