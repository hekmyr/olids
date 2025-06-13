import { Directive, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[inputStyle]',
  standalone: true,
})
export class InputDirective {
  @Input('inputStyle') style: string | null = null;

  @HostBinding('class')
  get classes(): string {
    switch (this.style) {
      case "invisible":
        return "outline-none w-full text-[20px] placeholder:text-disabled input-min-width input-max-width"
      default:
        return "w-full border-1 focus:ring-1 border-gray-400 rounded p-1 text-lg placeholder:text-disabled";
    }
  }

}
