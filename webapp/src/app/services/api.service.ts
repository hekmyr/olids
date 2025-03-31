import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { SignInDTO } from '../dtos/sign-in.dto';
import { SignUpDTO } from '../dtos/sign-up.dto';
import { RentalPropertyInterface } from '../interfaces/rental-property.interface';
import { RentalPropertyRequestDTO } from '../dtos/rental-property-request.dto';
import { ReservationCreateDTO } from '../dtos/reservation-create.dto';
import { ReservationInterface } from '../interfaces/reservation.interface';
import { ContactRequestDTO } from '../dtos/contact-request.dto';
import { UserModel } from '../models/user.model';
import { UserUpdateModel } from '../models/user-update.model';
import { BillingInformationInterface } from '../interfaces/billing-information.interface';
import { BillingInformationCreateDTO } from '../dtos/billing-information-create.dto';
import { BillingInformationUpdateDTO } from '../dtos/billing-information-update.dto';
import { User } from '../interfaces/user.interface';
import { BillingInformationSetDefaultDTO } from '../dtos/billing-information-set-default.dto';
import { ResponseInterface } from '../interfaces/response.interface';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api/v1';

  private http = inject(HttpClient);

  public signIn(body: SignInDTO): Observable<Object> {
    const headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(body.email + ':' + body.password)
    });
    return this.http.get(`${this.apiUrl}/user/sign-in`, {
      headers: headers,
      responseType: 'text',
      withCredentials: true
    });
  }

  public signUp(body: SignUpDTO): Observable<Object> {
    return this.http.post(`${this.apiUrl}/user/sign-up`, body);
  }

  public rentalProperties(
    body: RentalPropertyRequestDTO
  ): Observable<Array<RentalPropertyInterface>> {
    return this.http.post<Array<RentalPropertyInterface>>(
      `${this.apiUrl}/public/rental-properties`,
      body
    );
  }

  public rentalProperty(id: string): Observable<RentalPropertyInterface> {
    return this.http.get<RentalPropertyInterface>(
      `${this.apiUrl}/public/rental-property/${id}`
    );
  }

  public createReservation(
    payload: ReservationCreateDTO
  ): Observable<ReservationInterface> {
    return this.http.post<ReservationInterface>(
      `${this.apiUrl}/reservation`,
      payload,
      {
        withCredentials: true
      }
    );
  }

  public getReservations(): Observable<Array<ReservationInterface>> {
    return this.http.get<Array<ReservationInterface>>(
      `${this.apiUrl}/reservations`
    );
  }

  public sendContactRequest(body: ContactRequestDTO): Observable<Object> {
    return this.http.post(`${this.apiUrl}/public/contact`, body);
  }

  public getUser(): Observable<User> {
    return this.http.get<UserModel>(`${this.apiUrl}/user`, {
      withCredentials: true
    });
  }

  public updateUser(body: UserUpdateModel): Observable<User> {
    return this.http.put<UserModel>(`${this.apiUrl}/user`, body, {
      withCredentials: true
    });
  }

  public createBillingInformation(
    BillingInformationInterface: BillingInformationCreateDTO
  ): Observable<BillingInformationInterface> {
    return this.http.post<BillingInformationInterface>(
      `${this.apiUrl}/billing-information`,
      BillingInformationInterface,
      { withCredentials: true }
    );
  }

  public updateBillingInformation(
    BillingInformationInterface: BillingInformationUpdateDTO
  ): Observable<BillingInformationInterface> {
    return this.http.put<BillingInformationInterface>(
      `${this.apiUrl}/billing-information`,
      BillingInformationInterface,
      { withCredentials: true }
    );
  }

  public getBillingInformation(
    id: string
  ): Observable<BillingInformationInterface> {
    return this.http.get<BillingInformationInterface>(
      `${this.apiUrl}/billing-information/${id}`,
      { withCredentials: true }
    );
  }

  public getAllBillingInformations(): Observable<
    Array<BillingInformationInterface>
  > {
    return this.http.get<Array<BillingInformationInterface>>(
      `${this.apiUrl}/billing-information/all`,
      { withCredentials: true }
    );
  }

  public setDefaultCard(
    payload: BillingInformationSetDefaultDTO
  ): Observable<BillingInformationInterface> {
    return this.http.put<BillingInformationInterface>(
      `${this.apiUrl}/billing-information/set-default`,
      payload,
      { withCredentials: true }
    );
  }

  public logout(): Observable<ResponseInterface> {
    return this.http.get<ResponseInterface>(`${this.apiUrl}/user/logout`, {
      withCredentials: true
    });
  }
}
