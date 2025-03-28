import { Component, input } from '@angular/core';

@Component({
  selector: 'app-h3',
  standalone: true,
  template: `<h3 class="text-h3 font-semibold {{ className() }}">
    <ng-content></ng-content>
  </h3>`
})
export class H3Component {
  public className = input<string>('');
}
