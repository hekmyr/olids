import { Directive, HostBinding } from '@angular/core';

@Directive({
  selector: '[heading2]',
  standalone: true,
})
export class Heading2Directive {

  @HostBinding('class')
  get classes(): string {
    return 'text-h2 sm:text-h2 md:text-h2 lg:text-h2 xl:text-h2 font-bold font-averia';
  }
}
