import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScheduleService } from '../schedule.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-schedule',
  templateUrl: './delete-update-schedule.component.html',
  styleUrls: ['./delete-update-schedule.component.css']
})
export class DeleteUpdateScheduleComponent implements OnInit {
  schedule;
  message;
  error;
  constructor(public scheduleService: ScheduleService,
              private router: Router) {
              this.schedule =  scheduleService.selectedScheduleToUpdate;
              }

  updateSchedule(form: NgForm) {
    this.scheduleService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/schedules');
        setTimeout(() => {
           this.message = null;
         }, 2000);
   
        form.reset();
       }
     }
     );
    }

    ngOnInit() {
    }
    
    }

