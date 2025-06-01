import { Component, input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-primary-button',
  standalone: true,
  imports: [FormsModule],
  template: `
    <button
      [type]="getType()"
      class="text-white bg-accent-2 px-8 py-2 rounded-lg hover:bg-accent-1 cursor-pointer">
      <ng-content></ng-content>
    </button>
  `
})
export class PrimaryButtonComponent {
  public placeholder = input<string>('');
  public type = input<string>('text');

  public getType(): string {
    return this.type();
  }
}
