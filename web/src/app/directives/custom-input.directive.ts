import { Directive, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[appCustomInput]',
  standalone: true,
})
export class CustomInputDirective {
  @Input('appCustomInput') placeholder: string = '';

  @HostBinding('class')
  get classes(): string {
    return 'outline-none w-full text-[20px] placeholder:text-disabled input-min-width input-max-width';
  }

  @HostBinding('attr.placeholder')
  get hostPlaceholder(): string {
    return this.placeholder;
  }
}
