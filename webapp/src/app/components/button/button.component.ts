import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-button',
  imports: [],
  templateUrl: './button.component.html'
})
export class ButtonComponent {
  public text = input.required<string>();
  public type = input<string>();
  public submit = output<void>();

  // Required to set the button type
  public getType(): string {
    return this.type() ?? 'button';
  }

  // Required to set an action when
  // the button is clicked
  public onClick() {
    this.submit.emit();
  }
}
