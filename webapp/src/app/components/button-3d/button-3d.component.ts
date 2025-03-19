import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-button-3d',
  imports: [],
  template: `
    <button
      class="text-white bg-[#A94A4A] rounded-sm py-2 px-3 cursor-pointer
             shadow-[0_6px_0_#883939] hover:shadow-[0_4px_0_#883939]
             hover:translate-y-[2px] active:shadow-[0_2px_0_#883939] active:translate-y-[4px]
             transition-all duration-150 font-medium tracking-wide relative
             border-b-4 border-[#883939] hover:bg-[#B95A5A]
             disabled:opacity-50 disabled:hover:bg-[#A94A4A] disabled:hover:shadow-[0_6px_0_#883939] disabled:hover:translate-y-0"
      [type]="getType()"
      (click)="onClick()"
      [disabled]="disabled()">
      {{ text() }}
    </button>
  `
})
export class Button3dComponent {
  public text = input.required<string>();
  public type = input<string>();
  public disabled = input<boolean>(false);
  public submit = output<void>();

  public getType(): string {
    return this.type() ?? 'button';
  }

  public onClick() {
    if (!this.disabled()) {
      this.submit.emit();
    }
  }
}
