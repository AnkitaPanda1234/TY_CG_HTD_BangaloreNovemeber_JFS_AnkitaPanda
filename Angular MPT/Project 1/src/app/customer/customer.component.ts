import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  message: string;
  customers = [
    {
      name: 'Rajasekher',
      email: 'rajsekher@gmail.com',
      phone: 8865438764
  },
   {
       name: 'Abhilash',
      email: 'Abhilash@gmail.com',
      phone: 8865438764
  },
   {
      name: 'Chandan',
      email: 'Chandan@gmail.com',
      phone: 8865438764
  },
   {
      name: 'Rahul Kumar',
      email: 'rahul@gmail.com',
      phone: 8865438764
  },
  {
      name: 'Giridhar',
      email: 'Giridhar@gmail.com',
      phone: 8865438764
  }
  ];

  constructor() { }

  ngOnInit() {
  }

}
