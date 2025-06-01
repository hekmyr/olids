import { Component, input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LucideAngularModule, ChevronDown } from 'lucide-angular';
import { signal } from '@angular/core';

@Component({
  selector: 'app-accordion',
  standalone: true,
  imports: [CommonModule, LucideAngularModule],
  template: `
    <div
      class="p-6 bg-white w-full custom-shadow rounded-md flex flex-col gap-4">
      <div
        class="text-h4 flex justify-between items-center cursor-pointer"
        (click)="toggleAccordion()">
        <span>{{ question() }}</span>
        <lucide-icon
          [name]="ChevronDown"
          [size]="24"
          class="transition-transform"
          [class.rotate-180]="isOpen()"></lucide-icon>
      </div>
      @if (isOpen()) {
        <div class="text-lg">
          <span>{{ answer() }}</span>
        </div>
      }
    </div>
  `,
  styles: ``
})
export class AccordionComponent {
  question = input.required<string>();
  answer = input<string>('');
  ChevronDown = ChevronDown;
  isOpen = signal<boolean>(false);

  toggleAccordion() {
    this.isOpen.update((value) => !value);
  }
}
