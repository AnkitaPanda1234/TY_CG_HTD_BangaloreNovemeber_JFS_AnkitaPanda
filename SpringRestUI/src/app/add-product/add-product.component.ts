import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private productService: ProductService) { }
message;
error;
  ngOnInit() {
  }
  addProduct(form: NgForm) {

    this.productService.postData(form.value).subscribe(data => {
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
