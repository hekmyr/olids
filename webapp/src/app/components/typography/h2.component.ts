import { Component, input } from '@angular/core';

@Component({
  selector: 'app-h2',
  standalone: true,
  template: `<h2 class="text-h2 font-bold {{ className() }}">
    <ng-content></ng-content>
  </h2>`
})
export class H2Component {
  public className = input<string>('');
}
