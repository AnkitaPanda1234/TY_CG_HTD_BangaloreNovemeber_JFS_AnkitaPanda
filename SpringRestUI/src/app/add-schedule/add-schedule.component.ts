import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {
  constructor(private scheduleService: ScheduleService) { }
  message;
  error;
    ngOnInit() {
    }
    addschedule(form: NgForm) {

      this.scheduleService.postData(form.value).subscribe(data => {
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
