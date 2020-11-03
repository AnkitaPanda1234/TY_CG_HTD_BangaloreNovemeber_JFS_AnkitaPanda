import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SchedulerService } from '../scheduler.service';

@Component({
  selector: 'app-scheduler',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent implements OnInit {
  message: string; 
  error;
scheduler: any;
  constructor(private schedulerServie: SchedulerService,
              private router: Router) {
    this.getscheduler();
  }
getscheduler() {
  this.schedulerServie.getData().subscribe(response => {
    console.log(response);
    this.scheduler = response.beans;
    console.log(this.scheduler);
  }, err => {
    console.log(err);
  });
}
deletescheduler(schedulers: any) {
this.schedulerServie.deleteData(schedulers).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.scheduler.splice(this.scheduler.indexOf(schedulers), 1);
    this.message = res.description;
  }else{
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectscheduler(schedulers) {
  // console.log(product);
  this.schedulerServie.selectedSchedulerToUpdate = schedulers;
  this.router.navigateByUrl('/delete-update-scheduler');
}
  ngOnInit() {
  }

}
