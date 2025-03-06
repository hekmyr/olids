import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-logo',
  imports: [RouterLink],
  templateUrl: './nav-bar-logo.component.html'
})
export class NavBarLogoComponent {
  text = input.required<string>();
  link = input.required<string>();
}
