import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BillingInformationService {
  constructor() {}

  public formatCardNumber(cardNumber: string): string {
    const cleanedNumber = cardNumber.replace(/\D/g, '');

    if (this.cardType(cardNumber) === 'American Express') {
      return cleanedNumber.replace(/(\d{4})(\d{6})(\d{5})/, '$1 $2 $3');
    } else {
      return cleanedNumber.replace(/(\d{4})(?=\d)/g, '$1 ');
    }
  }

  public maskCardNumber(cardNumber: string): string {
    const cleanedNumber = cardNumber.replace(/\D/g, '');

    if (this.cardType(cardNumber) === 'American Express') {
      const lastFive = cleanedNumber.slice(-5);
      const maskedPart1 = '*'.repeat(4);
      const maskedPart2 = '*'.repeat(6);
      return `${maskedPart1} ${maskedPart2} ${lastFive}`;
    } else {
      const lastFour = cleanedNumber.slice(-4);
      const maskedMiddle =
        '*'.repeat(4) + ' ' + '*'.repeat(4) + ' ' + '*'.repeat(4);
      return `${maskedMiddle} ${lastFour}`;
    }
  }

  private cardType(cardNumber: string): string {
    const cleanedNumber = cardNumber.replace(/\D/g, '');
    if (cleanedNumber.length === 15) {
      return 'American Express';
    } else {
      return 'Visa/MasterCard';
    }
  }
}
