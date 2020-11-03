import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
  selectedScheduleToUpdate;
  api = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  postData(schedule): Observable<any> {
    return this.http.post<any>(
      `http://localhost:8080/springrest/addschedule`,
      schedule);
   }

    getData(): Observable<any> {
    return this.http.get<any>(`http://localhost:8080/springrest/getAllschedule`);
    }
    deleteData(schedule: any): Observable<any> {
      return this.http.delete<any>(`http://localhost:8080/springrest/deleteSchedule/${schedule.scheduleId}`);
    }
    updateData(schedule): Observable<any> {
      return this.http.put<any>(
        `${this.api}/forestrymanagementsystem/modify-schedule`,
        schedule
      );
    }
}

