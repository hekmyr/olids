import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonComponent } from '../../button/button.component';
import { InputComponent } from '../../input/input.component';
import { LinkComponent } from '../../link/link.component';
import { NavBarComponent } from '../../nav-bar/nav-bar.component';
import { SideImgComponent } from '../../side-img/side-img.component';
import { Link } from '../link.interface';
import { ApiService } from '../../../services/api.service';
import { SignUpDTO } from '../../../dto/sign-up-dto';
import { SignCardComponent } from '../sign-card.interface';

@Component({
  selector: 'app-sign-up-card',
  imports: [
    FormsModule,
    ButtonComponent,
    LinkComponent,
    SideImgComponent,
    InputComponent
  ],
  templateUrl: '../sign-card.component.html'
})
export class SignUpCardComponent implements SignCardComponent {
  public title = 'Inscription';
  public link = {
    text: 'Se connecter',
    url: '/sign-in'
  } as Link;
  public buttonText = 'Créer un compte';

  public imageUrl = 'images/sign_component_side_img.jpg';
  private form = new SignUpDTO();

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

  apiService = inject(ApiService);

  public submit(): void {
    this.apiService.signUp(this.form).subscribe();
  }
}
