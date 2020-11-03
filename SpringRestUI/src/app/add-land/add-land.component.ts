import { Component, OnInit } from '@angular/core';
import { LandService } from '../land.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-land',
  templateUrl: './add-land.component.html',
  styleUrls: ['./add-land.component.css']
})
export class AddLandComponent implements OnInit {
  constructor(private landService: LandService) { }
  message;
  error;
  today = Date.now();
    ngOnInit() {
    }
    addLand(form: NgForm) {

      this.landService.postData(form.value).subscribe(data => {
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
    }}
