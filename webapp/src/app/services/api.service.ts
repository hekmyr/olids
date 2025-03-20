import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignInDTO } from '../dto/sign-in-dto';
import { SignUpDTO } from '../dto/sign-up-dto';
import { RentalProperty } from '../interface/rental-property.interface';
import { RentalPropertyRequestDTO } from '../dto/rental-property-request.dto';
import { ReservationCreateDTO } from '../dto/reservation-create-dto';
import { Reservation } from '../interface/reservation.interface';
import { ContactRequestDTO } from '../dto/contact-request.dto';
import { UserDTO } from '../dto/user-dto';
import { UserUpdateDTO } from '../dto/user-update-dto';
import { BillingInformationDTO } from '../dto/billing-information.dto';
import { BillingInformation } from '../interface/billing-information.interface';
import { BillingInformationCreateDTO } from '../dto/billing-information-create-dto';
import { BillingInformationUpdateDTO } from '../dto/billing-information-update-dto';
import { User } from '../interface/user.interface';
import { BillingInformationSetDefaultDTO } from '../dto/billing-information-set-default-dto';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {}

  public signIn(body: SignInDTO): Observable<Object> {
    const headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(body.getEmail + ':' + body.getPassword)
    });
    return this.http.get(`${this.apiUrl}/user/sign-in`, {
      headers: headers,
      responseType: 'text',
      withCredentials: true
    });
  }

  public signUp(body: SignUpDTO): Observable<Object> {
    return this.http.post(`${this.apiUrl}/public/sign-up`, body);
  }

  public rentalProperties(
    body: RentalPropertyRequestDTO
  ): Observable<Array<RentalProperty>> {
    return this.http.post<Array<RentalProperty>>(
      `${this.apiUrl}/public/rental-properties`,
      body
    );
  }

  public rentalProperty(id: string): Observable<RentalProperty> {
    return this.http.get<RentalProperty>(
      `${this.apiUrl}/public/rental-property/${id}`
    );
  }

  public createReservation(
    payload: Array<ReservationCreateDTO>
  ): Observable<Reservation> {
    return this.http.post<Reservation>(`${this.apiUrl}/reservation`, payload, {
      withCredentials: true
    });
  }

  public sendContactRequest(body: ContactRequestDTO): Observable<Object> {
    return this.http.post(`${this.apiUrl}/public/contact`, body);
  }

  public getUser(): Observable<User> {
    return this.http.get<UserDTO>(`${this.apiUrl}/user`, {
      withCredentials: true
    });
  }

  public updateUser(body: UserUpdateDTO): Observable<User> {
    return this.http.put<UserDTO>(`${this.apiUrl}/user`, body, {
      withCredentials: true
    });
  }

  public createBillingInformation(
    billingInformation: BillingInformationCreateDTO
  ): Observable<BillingInformation> {
    return this.http.post<BillingInformation>(
      `${this.apiUrl}/billing-information`,
      billingInformation,
      { withCredentials: true }
    );
  }

  public updateBillingInformation(
    billingInformation: BillingInformationUpdateDTO
  ): Observable<BillingInformation> {
    return this.http.put<BillingInformation>(
      `${this.apiUrl}/billing-information`,
      billingInformation,
      { withCredentials: true }
    );
  }

  public getBillingInformation(id: string): Observable<BillingInformation> {
    return this.http.get<BillingInformation>(
      `${this.apiUrl}/billing-information/${id}`,
      { withCredentials: true }
    );
  }

  public getAllBillingInformations(): Observable<Array<BillingInformation>> {
    return this.http.get<Array<BillingInformation>>(
      `${this.apiUrl}/billing-information/all`,
      { withCredentials: true }
    );
  }

  public setDefaultCard(
    payload: BillingInformationSetDefaultDTO
  ): Observable<BillingInformation> {
    return this.http.put<BillingInformation>(
      `${this.apiUrl}/billing-information/set-default`,
      payload,
      { withCredentials: true }
    );
  }
}
