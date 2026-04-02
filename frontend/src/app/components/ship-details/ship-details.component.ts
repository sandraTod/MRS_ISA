import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-ship-details',
  templateUrl: './ship-details.component.html',
  styleUrls: ['./ship-details.component.css']
})
export class ShipDetailsComponent implements OnInit {
   
  @Input() data: any;

  @Output() servicesChanged = new EventEmitter<string[]>();

  selectedServices: string[] = [];

  constructor() { }

  ngOnInit(): void {
  }


onCheckboxChange(service: string, event: any) {
  if (event.target.checked) {
    this.selectedServices.push(service);
  } else {
    this.selectedServices = this.selectedServices.filter(s => s !== service);
  }

  this.servicesChanged.emit(this.selectedServices);
}

}
