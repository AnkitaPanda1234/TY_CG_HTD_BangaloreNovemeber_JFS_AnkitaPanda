import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SchedulerService {
  selectedSchedulerToUpdate;
  api = `http://localhost:8080`;
  constructor(private http: HttpClient) { }
  postData(scheduler): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/schedulerregister`,
    scheduler);
  }

  getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/showscheduler`);
  }

  deleteData(scheduler: any): Observable<any> {
    return this.http.delete<any>(
      `http://localhost:8080/springrest/deletescheduler/${scheduler.id}`
    );
  }
  updateData(schedulers): Observable<any> {
    return this.http.put<any>(
      `${this.api}/forestrymanagementsystem/change-password`,
      schedulers
    );
  }
  
}
