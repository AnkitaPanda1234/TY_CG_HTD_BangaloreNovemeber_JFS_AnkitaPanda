import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-delete-update-product',
  templateUrl: './delete-update-product.component.html',
  styleUrls: ['./delete-update-product.component.css']
})
export class DeleteUpdateProductComponent implements OnInit {
  product;
  message;
  error;
  constructor(public productService: ProductService,
              private router: Router) {
              this.product =  productService.selectedProductToUpdate;
              }

  updateProduct(form: NgForm) {
    this.productService.updateData(form.value).subscribe(res => {
      console.log(res);
      if (res.statusCode === 201) {
        this.message = res.description;
        localStorage.setItem('userDetails', JSON.stringify(res));
        this.router.navigateByUrl('/products');
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
