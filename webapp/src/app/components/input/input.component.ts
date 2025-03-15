import {
  Component,
  inject,
  input,
  output,
  OnChanges,
  SimpleChanges
} from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-input',
  imports: [ReactiveFormsModule],
  template: `
    <label>{{ label() }}</label>
    <input
      [type]="getType()"
      class="outline-none border-[#6A6A6A] border-2 rounded-sm w-full p-1"
      [formControl]="control"
      [min]="getMin()"
      (input)="onChange()" />
  `
})
export class InputComponent implements OnChanges {
  private fb = inject(FormBuilder);
  public control = this.fb.nonNullable.control('');

  public onChange() {
    this.value.emit(this.control.value);
  }

  public label = input.required<string>();
  public value = output<string>();
  public type = input<string>();
  public min = input<string>();
  public disabled = input<boolean>(false);

  public getType() {
    return this.type() ?? 'text';
  }

  public getMin() {
    return this.min() ?? '';
  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['disabled']) {
      if (this.disabled()) {
        this.control.disable();
      } else {
        this.control.enable();
      }
    }
  }
}
