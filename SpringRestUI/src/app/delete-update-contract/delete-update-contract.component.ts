import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { ContractService } from '../contract.service';

@Component({
  selector: 'app-delete-update-contract',
  templateUrl: './delete-update-contract.component.html',
  styleUrls: ['./delete-update-contract.component.css']
})
export class DeleteUpdateContractComponent implements OnInit {
  contract;
  message;
  error;
  constructor(public contractService: ContractService,
              private router: Router) {
              this.contract =  contractService.selectedContractToUpdate;
              }

  updateContract(form: NgForm) {
    this.contractService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/contracts');
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
