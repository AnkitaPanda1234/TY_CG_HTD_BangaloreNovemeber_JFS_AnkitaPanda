import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LandService {
  selectedLandToUpdate;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(land): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/addlanddetails`,
      land);
   }

    getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/getAllland`);
    }
    deleteData(land: any): Observable<any> {
      return this.http.delete<any>(`http://localhost:8080/springrest/deleteland/${land.landid}`);
    }

    updateData(land): Observable<any> {
      return this.http.put<any>(
        `http://localhost:8080/springrest/modifyland`,
        land
      );
    }
}
