import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-customer',
  templateUrl: './delete-update-customer.component.html',
  styleUrls: ['./delete-update-customer.component.css']
})
export class DeleteUpdateCustomerComponent implements OnInit {
  customers;
  message;
  error;
  constructor(public customerService: CustomerService,
              private router: Router) {
              this.customers =  customerService.selectedCustomerToUpdate;
              }

  updateCustomer(form: NgForm) {
    this.customerService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/customer');
        setTimeout(() => {
           this.message = null;
         }, 5000);
   
        form.reset();
       }
     }
     );
    }

    ngOnInit() {
    }
    
    }

