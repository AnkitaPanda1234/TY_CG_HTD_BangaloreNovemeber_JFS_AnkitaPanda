import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-schedules',
  templateUrl: './schedules.component.html',
  styleUrls: ['./schedules.component.css']
})
export class SchedulesComponent implements OnInit {
  message: string;
  error;
  schedules: any;
  constructor(private scheduleServie: ScheduleService,
              private router: Router) {
    this.getschedules();
  }
getschedules() {
  this.scheduleServie.getData().subscribe(response => {
    console.log(response);
    this.schedules = response.beans;
    console.log(this.schedules);
  }, err => {
    console.log(err);
  });
}
deleteschedule(schedule: any) {
this.scheduleServie.deleteData(schedule).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.schedules.splice(this.schedules.indexOf(schedule), 1);
    this.message = res.description;
  } else {
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectschedule(schedule) {
  // console.log(schedule);
  this.scheduleServie.selectedScheduleToUpdate = schedule;
  this.router.navigateByUrl('/delete-update-schedule');
}
  ngOnInit() {
  }

}

