import { Component, inject, input, output } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-input',
  imports: [ReactiveFormsModule],
  templateUrl: './input.component.html'
})
export class InputComponent {
  private fb = inject(FormBuilder);
  public control = this.fb.nonNullable.control('');

  public onChange() {
    this.value.emit(this.control.value);
  }

  public label = input.required<string>();
  public value = output<string>();
  public type = input<string>();

  public getType() {
    return this.type() ?? 'text';
  }
}
