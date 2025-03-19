import { Component, input } from '@angular/core';

@Component({
  selector: 'app-dashboard-header',
  imports: [],
  template: `
    <div class="flex flex-col gap-[10px]">
      <h2 class="text-2xl font-[Averia_Serif_Libre]">{{ title() }}</h2>
      <span class="text-sm text-[#666666]">{{ description() }}</span>
    </div>
  `
})
export class DashboardHeaderComponent {
  public title = input.required<string>();
  public description = input<string | null>(null);
}
