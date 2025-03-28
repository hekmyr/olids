import { Component, input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-custom-input',
  standalone: true,
  imports: [FormsModule],
  template: `
    <input
      class="outline-none w-full text-[20px] placeholder:text-disabled input-min-width input-max-width"
      placeholder="{{ placeholder() }}" />
  `
})
export class CustomInputComponent {
  public placeholder = input<string>('');
}
