import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { SignInDTO } from '../dto/sign-in-dto';
import { SignUpDTO } from '../dto/sign-up-dto';

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
}
