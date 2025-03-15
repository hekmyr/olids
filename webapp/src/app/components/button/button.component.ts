import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-button',
  imports: [],
  template: `
    <button
      class="text-white bg-[#A94A4A] w-full rounded-sm py-1 cursor-pointer hover:bg-[#B95A5A] transition-colors duration-200"
      [type]="getType()"
      (click)="onClick()"
      [disabled]="disabled()">
      {{ text() }}
    </button>
  `
})
export class ButtonComponent {
  public text = input.required<string>();
  public type = input<string>();
  public disabled = input<boolean>();
  public submit = output<void>();

  public getType(): string {
    return this.type() ?? 'button';
  }

  public onClick() {
    this.submit.emit();
  }
}
