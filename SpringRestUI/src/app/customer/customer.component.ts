import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  message: string;
  
  error;
customer: any;
  constructor(private customerServie: CustomerService,
              private router: Router) {
    this.getCustomer();
  }
getCustomer() {
  this.customerServie.getData().subscribe(response => {
    console.log(response);
    this.customer = response.beans;
    console.log(this.customer);
  }, err => {
    console.log(err);
  });
}
deleteCustomer(customers: any) {
this.customerServie.deleteData(customers).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.customer.splice(this.customer.indexOf(customers), 1);
    this.message = res.description;
  }else{
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectCustomer(customers) {
  // console.log(product);
  this.customerServie.selectedCustomerToUpdate = customers;
  this.router.navigateByUrl('/delete-update-customer');
}
  ngOnInit() {
  }

}