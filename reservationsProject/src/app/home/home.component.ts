import { ChangeDetectionStrategy, ChangeDetectorRef, Component, ElementRef, Input, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationDTO } from '../DTO/ReservationDTO';
import { ReservationsServiceService } from '../service/reservations-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  title = 'reservations project';
  public datasource: Array<any> = new Array<any>();
  displayedColumns: string[] = ['idReservation', 'nameReservation', 'dateReservation', 'hoursReservation', 'fieldReservation'];

  @ViewChild('nameReservation') nameReservation: ElementRef;
  @ViewChild('dateReservation') dateReservation: ElementRef;
  @ViewChild('hoursReservation') hoursReservation: ElementRef;
  @ViewChild('fieldReservation') fieldReservation: ElementRef;

  @ViewChild('nameReservationD') nameReservationD: ElementRef;
  @ViewChild('dateReservationD') dateReservationD: ElementRef;
  @ViewChild('hoursReservationD') hoursReservationD: ElementRef;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: ReservationsServiceService,
    private readonly cd: ChangeDetectorRef){}

  ngOnInit() {
    this.getAllReservations();
  }

  getAllReservations() {
    this.service.getAllReservations().subscribe(res=>{
       this.datasource = res;
    });
  }

  createReservation() {
    let newReservation = new ReservationDTO;
    newReservation.nameReservation = this.nameReservation.nativeElement.value;
    newReservation.dateReservation = this.dateReservation.nativeElement.value;
    newReservation.hoursReservation = this.hoursReservation.nativeElement.value;
    newReservation.fieldReservation = this.fieldReservation.nativeElement.value;

    if(newReservation.nameReservation !== '' && newReservation.dateReservation !== null &&
        newReservation.hoursReservation !== 0 && newReservation.fieldReservation !== 0) {
      console.log(newReservation);
      this.service.createReservation(newReservation).subscribe(res=>{});
    }
  }

  deleteReservationByNameAndDate() {
    if(this.nameReservationD.nativeElement.value !== '' && this.dateReservationD.nativeElement.value
     !== null && this.hoursReservationD.nativeElement.value !== 0) {
      console.log('service open delete');
      this.service.deleteReservationByNameAndDate(this.nameReservationD.nativeElement.value, this.dateReservationD.nativeElement.value
        , this.hoursReservationD.nativeElement.value).subscribe(res=>{
        console.log(res);
      });
    }
  }

  navigateUpdateReservation() {
    // PROVA DEL FOREACH SOLO PER ESEMPIO
    let surname = '';
    let id = '';
    this.datasource.forEach(element => {
      // in this way it takes always last value
      id = element.idReservation;
      surname = element.nameReservation;
    });

    this.router.navigate(['update-reservation', {idReservation: id, nameReservation: surname}], { relativeTo: this.route.parent });
  }

  clearInsertFields() {
    this.nameReservation.nativeElement.value = '';
    this.dateReservation.nativeElement.value = '';
    this.hoursReservation.nativeElement.value = '';
    this.fieldReservation.nativeElement.value = '';
    this.cd.markForCheck();
  }

  clearDeleteFields() {
    this.nameReservationD.nativeElement.value = '';
    this.dateReservationD.nativeElement.value = '';
    this.hoursReservationD.nativeElement.value = '';
    this.cd.markForCheck();
  }

}
