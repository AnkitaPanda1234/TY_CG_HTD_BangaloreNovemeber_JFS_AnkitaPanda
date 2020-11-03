import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-client',
  templateUrl: './delete-update-client.component.html',
  styleUrls: ['./delete-update-client.component.css']
})
export class DeleteUpdateClientComponent implements OnInit {
  clients;
  message;
  error;
  constructor(public clientService: ClientService,
              private router: Router) {
              this.clients =  clientService.selectedClientToUpdate;
              }

  updateclient(form: NgForm) {
    this.clientService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/client');
        setTimeout(() => {
           this.message = null;
         }, 3000);
   
        form.reset();
       }
     }
     );
    }

    ngOnInit() {
    }
    
    }

