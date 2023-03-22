import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ReservationDTO } from '../DTO/ReservationDTO';

@Injectable({
  providedIn: 'root'
})
export class ReservationsServiceService {

  constructor(private http: HttpClient) {}

  getAllReservations() :Observable<any> {
    return this.http.get('http://localhost:3000/reservations');
  }

  getReservationById(id: string) :Observable<any> {
    return this.http.get('http://localhost:3000/reservation/' + id);
  }

  createReservation(newReservation: ReservationDTO): Observable<any> {
    return this.http.post('http://localhost:3000/reservation', newReservation);
  }

  modifyReservation(modifyReservation: ReservationDTO): Observable<any> {
    return this.http.put('http://localhost:3000/modifyReservation', modifyReservation);
  }

  deleteReservationById(id: string) :Observable<any> {
    return this.http.delete('http://localhost:3000/reservations/' + id);
  }

  getReservationByName(name: string):Observable<any> {
    return this.http.get('http://localhost:3000/reservations/'+ name);
  }

  deleteReservationByNameAndDate(name: string, date: string, hour: string):Observable<any> {
    return this.http.delete('http://localhost:3000/reservation/delete/'+name+'/'+date+'/'+hour);
  }

  getReservationsOfDay(date: string):Observable<any> {
    return this.http.get('http://localhost:3000/reservations/day/'+date);
  }

  getReservationsBetweenDates(dateFrom: string, dateTo: string):Observable<any> {
    return this.http.get('http://localhost:3000/reservations/days/'+dateFrom+'/'+dateTo);
  }

  getReservationsOfCurrentWeek():Observable<any> {
    return this.http.get('http://localhost:3000/reservations/current/week');
  }

  getReservationsOfCurrentMonth():Observable<any> {
    return this.http.get('http://localhost:3000/reservations/current/month');
  }
}
