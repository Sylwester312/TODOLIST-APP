import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = environment.apiUrl;
  private userSubject: BehaviorSubject<any>;
  public user: Observable<any>;

  constructor(private http: HttpClient) {
    this.userSubject = new BehaviorSubject<any>(
      JSON.parse(localStorage.getItem('user') || '{}')
    );
    this.user = this.userSubject.asObservable();
  }

  signUp(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/auth/sign-up`, data);
  }

  signIn(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/auth/sign-in`, data);
  }

  logout() {
    localStorage.removeItem('user');
    this.userSubject.next(null);
  }
}
