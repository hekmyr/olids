import { Component, input, signal, effect } from '@angular/core';

@Component({
  selector: 'app-accordion',
  imports: [],
  template: `
    <div
      class="w-full text-2xl pb-2 select-none cursor-pointer"
      (click)="toggleOpen()">
      {{ title() }}
    </div>
    <hr />
    @if (isOpen()) {
      <div class="py-4">
        <p>
          {{ text() }}
        </p>
      </div>
    }
  `
})
export class AccordionComponent {
  public title = input.required<string>();
  public text = input.required<string>();
  public open = input<boolean>(false);

  public isOpen = signal<boolean>(false);

  constructor() {
    this.isOpen.set(this.open());

    effect(() => {
      this.isOpen.set(this.open());
    });
  }

  public toggleOpen() {
    this.isOpen.update((current) => !current);
  }
}
