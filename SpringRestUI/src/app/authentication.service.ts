import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/springrest/login`, userCredentials);
  }
}
