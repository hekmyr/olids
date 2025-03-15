export class RentalPropertyImageDTO {
  constructor(
    private _primaryImageUrl: string,
    private _alternativeImageUrls: Array<string>
  ) {}

  get primaryImageUrl(): string {
    return this._primaryImageUrl;
  }

  set primaryImageUrl(value: string) {
    this._primaryImageUrl = value;
  }

  get alternativeImageUrls(): Array<string> {
    return this._alternativeImageUrls;
  }

  set alternativeImageUrls(value: Array<string>) {
    this._alternativeImageUrls = value;
  }
}
