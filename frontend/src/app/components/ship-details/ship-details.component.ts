import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-ship-details',
  templateUrl: './ship-details.component.html',
  styleUrls: ['./ship-details.component.css']
})
export class ShipDetailsComponent implements OnInit {
   
  @Input() data: any;

  constructor() { }

  ngOnInit(): void {
  }

}
