import { Component, input } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-custom-textarea',
  standalone: true,
  imports: [FormsModule],
  template: `
    <textarea
      rows="5"
      class="w-full text-[20px] placeholder:text-disabled input-min-width input-max-width bg-[#CFD0D4]/60 rounded-[8px] border-[1px] border-[#646466] p-[8px] resize-none outline-none"
      placeholder="{{ placeholder() }}"></textarea>
  `
})
export class CustomTextareaComponent {
  public placeholder = input<string>('');
}
