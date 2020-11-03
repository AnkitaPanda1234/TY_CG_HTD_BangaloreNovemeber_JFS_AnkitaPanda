import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  message: string; 
  error;
client: any;
  constructor(private clientServie: ClientService,
              private router: Router) {
    this.getclient();
  }
getclient() {
  this.clientServie.getData().subscribe(response => {
    console.log(response);
    this.client = response.beans;
    console.log(this.client);
  }, err => {
    console.log(err);
  });
}
deleteclient(clients: any) {
this.clientServie.deleteData(clients).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.client.splice(this.client.indexOf(clients), 1);
    this.message = res.description;
  }else{
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectclient(clients) {
  // console.log(product);
  this.clientServie.selectedClientToUpdate = clients;
  this.router.navigateByUrl('/delete-update-client');
}
  ngOnInit() {
  }

}