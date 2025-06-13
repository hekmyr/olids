import { Directive, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[buttonStyle]',
  standalone: true,
})
export class ButtonDirective {
  @Input('buttonStyle') style: string | null = null;

  @HostBinding('class')
  get classes(): string {
    switch (this.style) {
      case "3d":
        return "bg-accent-2 text-white text-[20px] py-[10px] px-[20px] border-none rounded-[5px] shadow-[0_8px_0_var(--accent-1-color)] transition-[box-shadow,transform] duration-100 cursor-pointer hover:shadow-[0_12px_0_var(--accent-1-color)] hover:-translate-y-1 active:shadow-[0_4px_0_var(--accent-1-color)] active:translate-y-1";
      default:
        return "";
    }
  }

}
