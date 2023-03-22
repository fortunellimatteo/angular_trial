import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pipeHours'
})
export class PipeHoursPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return value + '.00';
  }

}
