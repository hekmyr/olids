import { Component, input } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-link',
  imports: [RouterLink],
  templateUrl: './link.component.html'
})
export class LinkComponent {
  public text = input.required<string>();

  public getText(): string {
    return this.text();
  }

  public link = input<string>();

  public getLink(): string {
    return this.link() || "#";
  }
}
