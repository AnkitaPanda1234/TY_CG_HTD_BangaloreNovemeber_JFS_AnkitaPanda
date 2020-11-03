import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LandService } from '../land.service';

@Component({
  selector: 'app-lands',
  templateUrl: './lands.component.html',
  styleUrls: ['./lands.component.css']
})
export class LandsComponent implements OnInit {
  message: string; 
  error;
  lands: any;
  constructor(private landService: LandService,
              private router: Router) {
    this.getLands();
  }
getLands() {
  this.landService.getData().subscribe(response => {
    console.log(response);
    this.lands = response.beans;
    console.log(this.lands);
  }, err => {
    console.log(err);
  });
}
deleteland(land: any) {
this.landService.deleteData(land).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.lands.splice(this.lands.indexOf(land), 1);
    this.message = res.description;
  }else{
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectland(land) {
  // console.log(land);
  this.landService.selectedLandToUpdate = land;
  this.router.navigateByUrl('/delete-update-land');
}
  ngOnInit() {
  }

}
