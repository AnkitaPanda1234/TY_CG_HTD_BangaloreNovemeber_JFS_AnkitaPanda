import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SchedulerService } from '../scheduler.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-scheduler',
  templateUrl: './delete-update-scheduler.component.html',
  styleUrls: ['./delete-update-scheduler.component.css']
})
export class DeleteUpdateSchedulerComponent implements OnInit {

  schedulers;
  message;
  error;
  constructor(public schedulerService: SchedulerService,
              private router: Router) {
              this.schedulers =  schedulerService.selectedSchedulerToUpdate;
              }

  updatescheduler(form: NgForm) {
    this.schedulerService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/scheduler');
        setTimeout(() => {
           this.message = null;
         }, 3000);
   
        form.reset();
       }
     }
     );
    }

    ngOnInit() {
    }
    
    }


