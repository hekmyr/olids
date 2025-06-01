export interface BillingInformationInterface {
  id: string;
  cardNumber: string;
  monthExpiration: number;
  yearExpiration: number;
  isDefault: boolean;
}
