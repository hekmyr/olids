import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-link',
  imports: [RouterLink],
  templateUrl: './nav-bar-link.component.html'
})
export class NavBarLinkComponent {
  text = input.required<string>();
  link = input.required<string>();
}
