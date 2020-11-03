import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  message: string;
  error;
  constructor(private auth: AuthenticationService,
    private router: Router) { }
  login(form: NgForm) {
    this.auth.loginUser(form.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 201) {
        this.message = response.description;;
        localStorage.setItem('userDetails.beans[0]', JSON.stringify(response));
        console.log('user details stored in local storage');
        if (response.beans[0].role == 'client') {
          this.router.navigateByUrl('/client-account');
        } else if (response.beans[0].role == 'scheduler') {
          this.router.navigateByUrl('/scheduler-account')
        } else if (response.beans[0].role == 'admin') {
          this.router.navigateByUrl('/admin');
        }
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
