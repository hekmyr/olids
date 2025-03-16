import { inject, Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { SignInDTO } from '../dto/sign-in-dto';
import { BehaviorSubject, firstValueFrom, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isAuthenticatedKey = 'isAuthenticated';
  private authStateSubject = new BehaviorSubject<boolean>(
    this.getIsAuthenticated()
  );
  public authState$: Observable<boolean> = this.authStateSubject.asObservable();

  constructor() {
    const isAuthenticated = localStorage.getItem(this.isAuthenticatedKey);
    if (isAuthenticated === null) {
      this.setAuthenticated(false);
    }
  }

  public getIsAuthenticated(): boolean {
    const isAuthenticated = localStorage.getItem(this.isAuthenticatedKey);
    return isAuthenticated === 'true';
  }

  public setAuthenticated(isAuthenticated: boolean): void {
    localStorage.setItem(this.isAuthenticatedKey, isAuthenticated.toString());
    this.authStateSubject.next(isAuthenticated);
  }

  apiService = inject(ApiService);

  public async signIn(dto: SignInDTO): Promise<void> {
    return firstValueFrom(this.apiService.signIn(dto))
      .then(() => {
        console.log('You are authenticated');
        this.setAuthenticated(true);
      })
      .catch((err) => {
        this.setAuthenticated(false);
        console.error(err);
      });
  }
}
