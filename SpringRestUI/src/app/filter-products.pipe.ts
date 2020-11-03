import { Pipe, PipeTransform } from '@angular/core';
import { ProductsComponent } from './products/products.component';

@Pipe({
  name: 'filterProducts'
})
export class FilterProductsPipe implements PipeTransform {

  transform(products: Product[], search:string): Product[] {
    if(search === undefined){
    return products;
  }
  return products.filter((product, index) => {
    return product.productname.toLowerCase().includes(search.toLowerCase());
  });
}

}
