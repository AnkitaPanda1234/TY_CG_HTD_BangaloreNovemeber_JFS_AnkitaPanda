import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  api = 'http://localhost:8080';
  selectedCustomerToUpdate;
  constructor(private http: HttpClient) { }

  postData(customers): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/addcustomer`,
      customers);
   }

    getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/getAllcustomer`);
    }
    deleteData(customers: any): Observable<any> {
      return this.http.delete<any>(`http://localhost:8080/springrest/deletecustomer/${customers.customerid}`);
    }
    updateData(customers): Observable<any> {
      return this.http.put<any>(
        `http://localhost:8080/springrest/modifycustomer`,
        customers
      );
    }
}
