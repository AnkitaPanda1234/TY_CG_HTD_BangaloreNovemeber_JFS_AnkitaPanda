import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  constructor(private customerService: CustomerService) { }
  message;
  error;
    ngOnInit() {
    }
    addCustomer(form: NgForm) {
      this.customerService.postData(form.value).subscribe(data => {
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

