import { Component, OnInit } from '@angular/core';
import { ClientauthService } from '../clientauth.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-loginclient',
  templateUrl: './loginclient.component.html',
  styleUrls: ['./loginclient.component.css']
})
export class LoginclientComponent implements OnInit {
  message: string;
  error;
  constructor(private auth: ClientauthService,
              private router: Router) { }
  login(form: NgForm) {
this.auth.loginUser(form.value).subscribe(response => {
    console.log(response);
    if (response.statusCode === 201) {
     this.message = response.description;
     localStorage.setItem('userDetails.beans[0]', JSON.stringify(response));
     console.log('user details stored in local storage');
     this.router.navigateByUrl('/client-account');
    } else {
      console.log(response);
      this.error = response.description;
      }
     setTimeout(() => {
        this.message = null;
      }, 2000);

     form.reset();
    }
  );
}
  ngOnInit() {
  }

}
