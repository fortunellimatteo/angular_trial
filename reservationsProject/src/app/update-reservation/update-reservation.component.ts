import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationDTO } from '../DTO/ReservationDTO';
import { ReservationsServiceService } from '../service/reservations-service.service';

@Component({
  selector: 'app-update-reservation',
  templateUrl: './update-reservation.component.html',
  styleUrls: ['./update-reservation.component.css']
})
export class UpdateReservationComponent implements OnInit {

  @Input() dateReservationU: string;
  @Input() hoursReservationU: string;
  @Input() fieldReservationU: string;
  @Input() nameRes: string;
  isDisabledDate: boolean;
  isDisabledHours: boolean;
  isDisabledField: boolean;
  updateReservation: ReservationDTO;

  constructor(private service: ReservationsServiceService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.isDisabledDate=true;
    this.isDisabledHours=true;
    this.isDisabledField=true;
    this.nameRes = this.route.snapshot.paramMap.get('nameReservation');
    let idRes = this.route.snapshot.paramMap.get('isReservation');
  }

  getReservationByName(nameReservationU: any) {
    this.service.getReservationByName(nameReservationU).subscribe(res=>{
      //this.nameReservationU = res[0].nameReservation;
      this.dateReservationU = res[0].dateReservation;
      this.hoursReservationU = res[0].hoursReservation;
      this.fieldReservationU = res[0].fieldReservation;
      this.updateReservation = res[0];
    });
    this.isDisabledDate=false;
    this.isDisabledHours=false;
    this.isDisabledField=false;
  }

  modifyReservationByName() {
    this.service.modifyReservation(this.updateReservation).subscribe(res=>{});
    this.isDisabledDate=true;
    this.isDisabledHours=true;
    this.isDisabledField=true;
  }

  navigateBack() {
    this.router.navigate(['home'], { relativeTo: this.route.parent });
  }
}
