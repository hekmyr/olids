import { Component, input } from '@angular/core';

@Component({
  selector: 'app-h2',
  standalone: true,
  template: `<h2 class="text-h2 sm:text-h2 md:text-h2 lg:text-h2 xl:text-h2 font-bold font-averia {{ className() }}">
    <ng-content></ng-content>
  </h2>`
})
export class H2Component {
  public className = input<string>('');
}
