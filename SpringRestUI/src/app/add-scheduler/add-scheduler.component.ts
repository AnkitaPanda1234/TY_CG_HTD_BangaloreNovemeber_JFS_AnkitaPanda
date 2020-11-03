import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { SchedulerService } from '../scheduler.service';

@Component({
  selector: 'app-add-scheduler',
  templateUrl: './add-scheduler.component.html',
  styleUrls: ['./add-scheduler.component.css']
})
export class AddSchedulerComponent implements OnInit {
  constructor(private schedulerService: SchedulerService) { }
  message;
  error;
    ngOnInit() {
    }
    addScheduler(form: NgForm) {

      this.schedulerService.postData(form.value).subscribe(data => {
        if (data.statusCode === 201) {
        console.log(data);
        this.message =  data.description;
        } else {
        console.log(data);
        this.error = data.description;
        }

        setTimeout(() => {
            this.message = null;
          }, 2000);
        form.reset();
          }
          );

    }
  }
