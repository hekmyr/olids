import { Component } from '@angular/core';
import { input } from '@angular/core';
import { LucideAngularModule } from 'lucide-angular';

@Component({
  selector: 'app-icon-text',
  standalone: true,
  imports: [LucideAngularModule],
  template: `
    <div
      class="icon-text border border-black rounded-lg p-2 flex flex-col items-center">
      <i-lucide [img]="icon()" [size]="44" class="mb-2"></i-lucide>
      <span class="text-[10px] text-center">{{ text() }}</span>
    </div>
  `
})
export class IconTextComponent {
  public icon = input<any>();
  public text = input<string>('');
}
