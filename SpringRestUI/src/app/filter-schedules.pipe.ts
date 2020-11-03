import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterSchedules'
})
export class FilterSchedulesPipe implements PipeTransform {
  transform(schedules: Schedule[], search:string): Schedule[] {
    if(search === undefined){
    return schedules;
  }
  return schedules.filter((schedule, index) => {
    return schedule.scheduleId.includes(search.toLowerCase());
  });
}

}