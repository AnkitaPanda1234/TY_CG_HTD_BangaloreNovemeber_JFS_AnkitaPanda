import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
   selectedContractToUpdate;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(contract): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/addcontract`,
      contract);
   }

    getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/getAllcontract`);
    }
    deleteData(contract: any): Observable<any> {
      return this.http.delete<any>(`http://localhost:8080/springrest/deletecontract/${contract.contractId}`);
    }
    updateData(contract): Observable<any> {
      return this.http.put<any>(
        `${this.api}/forestrymanagementsystem/modify-contract`,
        contract
      );
    }
}
