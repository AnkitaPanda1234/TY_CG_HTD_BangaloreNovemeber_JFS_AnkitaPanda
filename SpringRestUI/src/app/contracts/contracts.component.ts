import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ContractService } from '../contract.service';

@Component({
  selector: 'app-contracts',
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.css']
})
export class ContractsComponent implements OnInit {
  message: string; 
  error;
  contracts: any;
  constructor(private contractServie: ContractService,
              private router: Router) {
    this.getcontracts();
  }
getcontracts() {
  this.contractServie.getData().subscribe(response => {
    console.log(response);
    this.contracts = response.beans;
    console.log(this.contracts);
  }, err => {
    console.log(err);
  });
}
deletecontract(contract: any) {
this.contractServie.deleteData(contract).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.contracts.splice(this.contracts.indexOf(contract), 1);
    this.message = res.message;
  }else{
    this.error = res.message;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectcontract(contract) {
  // console.log(contract);
  this.contractServie.selectedContractToUpdate = contract;
  this.router.navigateByUrl('/delete-update-contract');
}
  ngOnInit() {
  }

}