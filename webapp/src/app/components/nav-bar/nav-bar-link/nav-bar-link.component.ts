import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-link',
  imports: [RouterLink],
  template: `
    <a class="font-[Averia_Serif_Libre] text-lg" routerLink="{{ link() }}">
      {{ text() }}
    </a>
  `
})
export class NavBarLinkComponent {
  text = input.required<string>();
  link = input.required<string>();
}
