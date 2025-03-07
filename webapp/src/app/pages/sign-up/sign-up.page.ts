import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonComponent } from '../../components/button/button.component';
import { InputComponent } from '../../components/input/input.component';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { SideImgComponent } from '../../components/side-img/side-img.component';
import { LinkComponent } from '../../components/link/link.component';
import { SignUpDTO } from '../../dto/sign-up-dto';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-sign-up',
  imports: [
    FormsModule,
    ButtonComponent,
    LinkComponent,
    NavBarComponent,
    SideImgComponent,
    InputComponent
  ],
  templateUrl: './sign-up.page.html'
})
export class SignUpPage {
  private form: SignUpDTO = new SignUpDTO();
  private apiService = inject(ApiService);
  public imageUrl = 'images/sign_component_side_img.jpg';

  // This get called by children component:
  // InputComponent
  public setEmail(value: string) {
    this.form.setEmail = value;
  }

  // This get called by children component:
  // InputPasswordComponent
  public setPassword(value: string) {
    this.form.setPassword = value;
  }

  public submit() {
    this.apiService.signUp(this.form).subscribe();
  }
}
