import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{

  constructor(private route: ActivatedRoute,
    private router: Router){}

  ngOnInit(): void {
    //this.router.navigate(['home'], { relativeTo: this.route.parent });
  }

}