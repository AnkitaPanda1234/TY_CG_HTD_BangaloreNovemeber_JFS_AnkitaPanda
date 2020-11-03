import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ContractService } from '../contract.service';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {
  constructor(private contractService: ContractService) { }
  message;
  error;
  today = Date.now();
    ngOnInit() {
    }
    addContract(form: NgForm) {
      this.contractService.postData(form.value).subscribe(data => {
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
