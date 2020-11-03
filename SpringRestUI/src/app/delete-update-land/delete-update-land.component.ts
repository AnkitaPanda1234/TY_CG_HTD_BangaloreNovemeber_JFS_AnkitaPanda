import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LandService } from '../land.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-land',
  templateUrl: './delete-update-land.component.html',
  styleUrls: ['./delete-update-land.component.css']
})
export class DeleteUpdateLandComponent implements OnInit {
  land;
  message;
  error;
  constructor(public landService: LandService,
              private router: Router) {
              this.land =  landService.selectedLandToUpdate;
              }

  updateLand(form: NgForm) {
    this.landService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/lands');
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
