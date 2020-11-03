import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterContracts'
})
export class FilterContractsPipe implements PipeTransform {
  transform(contracts: Contract[], search:string): Contract[] {
    if(search === undefined){
    return contracts;
  }
  return contracts.filter((contract, index) => {
    return contract.contractId.includes(search);
  });
}

}