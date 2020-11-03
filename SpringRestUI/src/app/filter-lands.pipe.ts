import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterLands'
})
export class FilterLandsPipe implements PipeTransform {
  transform(lands: Land[], search:string): Land[] {
    if(search === undefined){
    return lands;
  }
  return lands.filter((land, index) => {
    return land.landLocation.toLowerCase().includes(search.toLowerCase());
  });
}

}