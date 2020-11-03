import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientauthService {
  url = 'http://localhost:8080';
  constructor(private http: HttpClient) { }

  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`http://localhost:8080/springrest/login`, userCredentials);
  }
}

