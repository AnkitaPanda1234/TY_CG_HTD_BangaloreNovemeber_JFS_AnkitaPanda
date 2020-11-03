import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router, private location: Location) { }

  ngOnInit() {
  }
  isAdmin() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans[0]'))
    if (userDetails && userDetails.beans[0].role === 'admin') {
      return true;
    } else {
      return false;
    }
  }
  isClient() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans[0]'))
    if (userDetails && userDetails.beans[0].role === 'client') {
      return true;
    } else {
      return false;
    }
  }
  goBack() {
    this.location.back();
  }
  isScheduler() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans[0]'))
    if (userDetails && userDetails.beans[0].role === 'scheduler') {
      return true;
    } else {
      return false;
    }
  }
  isLoggedIn() {
    let userDetails = JSON.parse(localStorage.getItem('userDetails.beans[0]'));
    if (userDetails) {
      return true;
    } else {
      return false;
    }
  }
  logout() {
    localStorage.removeItem('userDetails.beans[0]');
    this.router.navigateByUrl('/');
  }
}
