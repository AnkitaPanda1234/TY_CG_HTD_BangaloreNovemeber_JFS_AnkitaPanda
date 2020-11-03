import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  message: string; 
  error;
  products: any;
  constructor(private productServie: ProductService,
              private router: Router) {
    this.getProducts();
  }
getProducts() {
  this.productServie.getData().subscribe(response => {
    console.log(response);
    this.products = response.beans;
    console.log(this.products);
  }, err => {
    console.log(err);
  });
}
deleteProduct(product: any) {
this.productServie.deleteData(product).subscribe(res => {
  console.log(res);
  if (res.statusCode === 201) {
    this.products.splice(this.products.indexOf(product), 1);
    this.message = res.description;
  }else{
    this.error = res.description;
  }
});
}

deleteMessage() {
  this.message = null;
}

selectProduct(product) {
  // console.log(product);
  this.productServie.selectedProductToUpdate = product;
  this.router.navigateByUrl('/delete-update-product');
}
  ngOnInit() {
  }

}
