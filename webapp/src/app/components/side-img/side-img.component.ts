import { Component, input } from '@angular/core';

@Component({
  selector: 'app-side-img',
  imports: [],
  templateUrl: './side-img.component.html'
})
export class SideImgComponent {
  public url = input.required<string>();
}
