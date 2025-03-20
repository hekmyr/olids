import { Component, input } from '@angular/core';
import { DashboardHeaderComponent } from '../dashboard-header/dashboard-header.component';
import { AvatarWithUploadComponent } from '../avatar-with-upload/avatar-with-upload.component';
import { ProfileFormComponent } from '../profile-form/profile-form.component';
import { User } from '../../../../interfaces/user.interface';

@Component({
  selector: 'app-profile',
  imports: [
    DashboardHeaderComponent,
    AvatarWithUploadComponent,
    ProfileFormComponent
  ],
  template: `
    <div class="flex flex-col gap-8">
      <app-dashboard-header
        title="Mon Profile"
        description="Mettez à jour votre profile" />
      <div class="flex gap-8">
        <app-avatar-with-upload />
        <div class="flex flex-col">
          <span class="text-xl">Compte crée en 2023</span>
          <span class="text-xl">7 Réservations</span>
          <span class="text-xl text-[#A94A4A]"
            >Historique des réservations</span
          >
        </div>
      </div>
      <app-profile-form [user]="null" />
    </div>
  `
})
export class ProfileComponent {
  public user = input.required<User | null>();
}
