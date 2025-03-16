import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ButtonComponent } from '../../button/button.component';
import { InputComponent } from '../../input/input.component';
import { LinkComponent } from '../../link/link.component';
import { NavBarComponent } from '../../nav-bar/nav-bar.component';
import { SideImgComponent } from '../../side-img/side-img.component';
import { SignInDTO } from '../../../dto/sign-in-dto';
import { Link } from '../link.interface';
import { SignCardComponent } from '../sign-card.interface';
import { AuthService } from '../../../services/auth.service';

@Component({
  selector: 'app-sign-in-card',
  imports: [
    FormsModule,
    ButtonComponent,
    LinkComponent,
    SideImgComponent,
    InputComponent
  ],
  templateUrl: '../sign-card.component.html'
})
export class SignInCardComponent implements SignCardComponent {
  public title = 'Connexion';
  public link: Link = {
    text: "S'inscrire",
    url: '/sign-up'
  };
  public buttonText = 'Se connecter';

  public imageUrl = 'images/sign_component_side_img.jpg';
  private form = new SignInDTO();

  public setEmail(value: string) {
    this.form.setEmail = value;
  }

  public setPassword(value: string) {
    this.form.setPassword = value;
  }

  authService = inject(AuthService);

  public submit() {
    this.authService.signIn(this.form);
  }
}
