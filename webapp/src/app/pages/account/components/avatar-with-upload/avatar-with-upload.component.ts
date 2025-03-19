import { Component, input, output, EventEmitter, signal } from '@angular/core';
import { LucideAngularModule, LucideUser } from 'lucide-angular';

@Component({
  selector: 'app-avatar-with-upload',
  standalone: true,
  imports: [LucideAngularModule],
  template: `
    <div
      class="group relative h-[84px] aspect-square overflow-hidden rounded-full">
      <input
        type="file"
        accept="image/*"
        class="absolute inset-0 w-full h-full opacity-0 cursor-pointer z-10"
        (change)="onFileSelected($event)" />

      <div
        class="absolute inset-0 transition-colors group-hover:bg-white opacity-20 z-2"></div>

      @if (imageUrl() !== null || previewUrl() !== null) {
        <img
          [src]="previewUrl() || imageUrl()"
          class="h-full w-full object-cover"
          alt="User avatar" />
      } @else {
        <div
          class="h-full w-full bg-[#CFD0D4] flex items-center justify-center">
          <lucide-angular
            class="h-full w-full p-2"
            [img]="userIcon"></lucide-angular>
        </div>
      }
    </div>
  `
})
export class AvatarWithUploadComponent {
  public imageUrl = input<string | null>(null);
  public fileSelected = output<File>();
  public previewUrl = signal<string | null>(null);
  public userIcon = LucideUser;

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    const file = input.files?.[0];

    if (file) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.previewUrl.set(e.target?.result as string);
      };
      reader.readAsDataURL(file);

      this.fileSelected.emit(file);
    }
  }
}
