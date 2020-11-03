import { Component, OnInit } from '@angular/core';
import { SchedulerauthService } from '../schedulerauth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-loginscheduler',
  templateUrl: './loginscheduler.component.html',
  styleUrls: ['./loginscheduler.component.css']
})
export class LoginschedulerComponent implements OnInit {
  message: string;
  error;
  constructor(private auth: SchedulerauthService,
              private router: Router) { }
  login(form: NgForm) {
this.auth.loginUser(form.value).subscribe(response => {
    console.log(response);
    if (response.statusCode === 201) {
     this.message = response.description;
     localStorage.setItem('userDetails.beans[0]', JSON.stringify(response));
     console.log('user details stored in local storage');
     this.router.navigateByUrl('/scheduler-account');
    } else {
      console.log(response);
      this.error = response.description;
      }
     setTimeout(() => {
        this.message = null;
      }, 3000);

     form.reset();
    }
  );
}
  ngOnInit() {
  }

}
