import { Component, inject } from '@angular/core';
import { RentalPropertyDTO } from '../../dto/rental-property.dto';
import { RentalPropertyImageDTO } from '../../dto/rental-property-image.dto';
import { NavBarComponent } from '../../components/nav-bar/nav-bar.component';
import { RentalPropertyFormSectionComponent } from './components/rental-property-form-section/rental-property-form-section.component';
import { ImageContext } from './interfaces/image-context.interface';
import { ActivatedRoute, Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-property',
  imports: [NavBarComponent, RentalPropertyFormSectionComponent],
  template: `
    @if (rentalProperty) {
      <div class="h-svh">
        <div
          class="h-full grid grid-rows-[auto_1fr_200px] grid-cols-[auto_900px]">
          <app-nav-bar class="col-span-2" />
          @if (imageContext.images.length > 0) {
            <div class="relative h-full row-span-2">
              <img
                class="h-full w-full object-cover"
                [src]="imageContext.images[imageContext.index]"
                alt="Rental property" />

              <button
                (click)="previousImage()"
                class="absolute left-4 top-1/2 transform -translate-y-1/2 bg-black text-white p-2 rounded-full opacity-70 hover:opacity-100 cursor-pointer">
                <svg
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                  class="w-8 aspect-square">
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M15 19l-7-7 7-7" />
                </svg>
              </button>

              <button
                (click)="nextImage()"
                class="absolute right-4 top-1/2 transform -translate-y-1/2 bg-black text-white p-2 rounded-full opacity-70 hover:opacity-100 cursor-pointer">
                <svg
                  viewBox="0 0 24 24"
                  stroke="currentColor"
                  class="w-8 aspect-square">
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    stroke-width="2"
                    d="M9 5l7 7-7 7" />
                </svg>
              </button>

              <div
                class="absolute bottom-4 left-1/2 transform -translate-x-1/2 flex space-x-2 bg-black p-2 rounded-lg opacity-60">
                @for (image of imageContext.images; track $index) {
                  <button
                    (click)="onSelectImage($index)"
                    class="focus:outline-none"
                    [attr.aria-label]="'View image ' + ($index + 1)">
                    <div
                      [class]="
                        $index === imageContext.index
                          ? 'w-10 h-3 bg-white rounded-full'
                          : 'w-3 aspect-square bg-white bg-opacity-60 rounded-full cursor-pointer hover:bg-opacity-100'
                      "></div>
                  </button>
                }
              </div>
            </div>
          } @else {
            <div class="relative h-full row-span-2">
              <img
                class="h-full w-full object-cover"
                src=""
                alt="Rental property" />
            </div>
          }
          <app-rental-property-form-section
            class="row-span-2 row-start-2 col-start-2"
            [rentalProperty]="rentalProperty" />
        </div>
      </div>
    } @else {
      <span>Loading...</span>
    }
  `
})
export class RentalPropertyPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);
  apiService = inject(ApiService);
  constructor() {
    this.activatedRoute.paramMap.subscribe((params) => {
      const id = params.get('id');
      if (id) {
        firstValueFrom(this.apiService.rentalProperty(id)).then((property) => {
          this.rentalProperty = RentalPropertyDTO.fromInterface(property);
        });
      }
    });
  }
  public rentalProperty: RentalPropertyDTO | undefined = undefined;

  // TODO: remove this when not needed
  // This is some sample data
  // Merge it with rpDTO
  public rentalPropertyImage = new RentalPropertyImageDTO(
    'images/sign_component_side_img.jpg',
    [
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg',
      'images/sign_component_side_img.jpg'
    ]
  );

  public imageContext: ImageContext = {
    index: 0,
    images: [
      this.rentalPropertyImage.primaryImageUrl,
      ...this.rentalPropertyImage.alternativeImageUrls
    ]
  };

  public onSelectImage(index: number): void {
    this.imageContext.index = index;
  }

  public nextImage(): void {
    this.imageContext.index =
      (this.imageContext.index + 1) % this.imageContext.images.length;
  }

  public previousImage(): void {
    this.imageContext.index =
      (this.imageContext.index - 1 + this.imageContext.images.length) %
      this.imageContext.images.length;
  }
}
