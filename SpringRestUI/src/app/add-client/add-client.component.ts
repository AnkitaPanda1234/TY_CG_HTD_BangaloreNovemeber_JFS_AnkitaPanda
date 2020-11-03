import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-add-client',
  templateUrl: './add-client.component.html',
  styleUrls: ['./add-client.component.css']
})
export class AddClientComponent implements OnInit {
  constructor(private clientService: ClientService) { }
  message;
  error;
    ngOnInit() {
    }
    addClient(form: NgForm) {

      this.clientService.postData(form.value).subscribe(data => {
        if (data.statusCode === 201) {   
          console.log(data);
          console.log(form.value);
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
