import { Component, input, output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-custom-input-text',
  standalone: true,
  imports: [InputTextModule, FormsModule],
  template: `
    <input
      type="text"
      pInputText
      class="w-full px-3 py-2 placeholder-gray-500 text-gray-900 rounded-md input-min-width placeholder:text-disabled"
      [placeholder]="placeholder()" />
  `,
  styles: `
    /* TODO: Figure out how to remove the !important while maintaining the style */
    :host ::ng-deep .p-inputtext:not(:focus) {
      border-color: var(--disabled) !important;
    }

    :host ::ng-deep .p-inputtext:focus {
      border-color: var(--accent-2-color) !important;
      outline: none !important;
      box-shadow: none !important;
    }
  `
})
export class CustomInputTextComponent {
  placeholder = input<string>('');
  value = output<string>();
}
