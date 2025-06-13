// olids/web/src/app/pipes/format-date.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatCurrency'
})
export class FormatCurrencyPipe implements PipeTransform {
  transform(value: number) {
    return new Intl.NumberFormat("fr-BE", {
      style: 'currency',
      currency: 'EUR'
    }).format(value);
  }
}
