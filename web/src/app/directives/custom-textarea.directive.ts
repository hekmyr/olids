import { Directive, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[appCustomTextarea]',
  standalone: true,
})
export class CustomTextareaDirective {
  @Input('appCustomTextarea') placeholder: string = '';

  @HostBinding('class')
  get classes(): string {
    return 'w-full text-[20px] placeholder:text-disabled input-min-width input-max-width bg-[#CFD0D4]/60 rounded-[8px] border-[1px] border-[#646466] p-[8px] resize-none outline-none';
  }

  @HostBinding('attr.rows')
  get rows(): number {
    return 5;
  }

  @HostBinding('attr.placeholder')
  get hostPlaceholder(): string {
    return this.placeholder;
  }
}
