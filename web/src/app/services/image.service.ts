import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor() { }

  public handleBase64(image: string) {
    return `data:image/jpeg;base64,${image}`;
  }
}
