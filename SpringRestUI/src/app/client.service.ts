import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  selectedClientToUpdate;
  api = `http://localhost:8080`;
  constructor(private http: HttpClient) { }

  postData(clients): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/clientregister`,
      clients);
   }

    getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/showclient`);
    }
    deleteData(clients: any): Observable<any> {
      return this.http.delete<any>(`http://localhost:8080/springrest/deleteclient/${clients.id}`);
    }
    updateData(clients): Observable<any> {
      return this.http.put<any>(
        `${this.api}/forestrymanagementsystem/change-password`,
        clients
      );
    }
    
}
