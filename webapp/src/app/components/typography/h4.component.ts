import { Component, input } from '@angular/core';

@Component({
  selector: 'app-h4',
  standalone: true,
  template: `<h4 class="text-h4 font-medium {{ className() }}">
    <ng-content></ng-content>
  </h4>`
})
export class H4Component {
  public className = input<string>('');
}
