import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterClient'
})
export class FilterClientPipe implements PipeTransform {
  transform(client: Client[], search:string): Client[] {
    if(search === undefined){
    return client;
  }
  return client.filter((clients, index) => {
    return clients.username.toLowerCase().includes(search.toLowerCase());
  });
}

}