import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterCustomer'
})
export class FilterCustomerPipe implements PipeTransform {
  transform(customer: Customer[], search:string): Customer[] {
    if(search === undefined){
    return customer;
  }
  return customer.filter((customers, index) => {
    return customers.customerName.toLowerCase().includes(search.toLowerCase());
  });
}

}