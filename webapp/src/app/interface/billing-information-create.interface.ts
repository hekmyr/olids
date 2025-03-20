export interface BillingInformationCreate {
  cardNumber: string | null;
  monthExpiration: number | null;
  yearExpiration: number | null;
}
