import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-sign-in',
  imports: [ReactiveFormsModule],
  templateUrl: './sign-in.page.html'
})
export class SignInPage {
  private fb = inject(FormBuilder);
  private api = inject(ApiService);
  public signInForm = this.fb.nonNullable.group({
    username: [''],
    password: ['']
  });
  public signIn(): void {
    const username = this.signInForm.get('username')?.value;
    const password = this.signInForm.get('password')?.value;
    if (!username) {
      let err = new Error('Undefined username is not allowed');
      throw err;
    }
    if (!password) {
      let err = new Error('Undefined password is not allowed');
      throw err;
    }
    this.api
      .signIn(username, password)
      .subscribe((data) => console.log('INFO', data, document.cookie));
  }
}
