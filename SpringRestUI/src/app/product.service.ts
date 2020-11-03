import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  selectedProductToUpdate;
  api = `http://localhost:8080`;
  constructor(private http: HttpClient) { }


  postData(product): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/addproduct`,
      product);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/getAllproduct`);
  }

  deleteData(product: any): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/springrest/deleteproduct/${product.productid}`
    );
  }

  updateData(product): Observable<any> {
    return this.http.put<any>(
      `http://localhost:8080/springrest/modifyproduct`,
      product
    );
  }
}
