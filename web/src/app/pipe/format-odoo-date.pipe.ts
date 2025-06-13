// olids/web/src/app/pipes/format-date.pipe.ts
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatOdooDate'
})
export class FormatOdooDatePipe implements PipeTransform {
  transform(value: string | undefined | null): string {
    if (!value || typeof value !== 'string') {
      return '';
    }

    const parts = value.split(" ");
    if (parts.length === 0 || !parts[0]) {
      return "";
    }

    const datePart = parts[0];
    const dateSegments = datePart.split("-");

    if (dateSegments.length !== 3) {
      console.error(`Invalid date string format for pipe: ${value}`);
      return value;
    }

    const year = dateSegments[0];
    const month = dateSegments[1];
    const day = dateSegments[2];

    if (!year || !month || !day) {
      console.error(`Invalid date segments for pipe in: ${value}`);
      return value;
    }

    return `${day}/${month}/${year}`;
  }
}
