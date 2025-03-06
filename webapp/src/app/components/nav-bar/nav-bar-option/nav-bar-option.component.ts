import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'nav-bar-option',
  imports: [],
  templateUrl: './nav-bar-option.component.html'
})
export class NavBarOptionComponent {
  text = input.required<string>();
}
