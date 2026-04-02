import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-cottage-details',
  templateUrl: './cottage-details.component.html',
  styleUrls: ['./cottage-details.component.css']
})
export class CottageDetailsComponent implements OnInit {

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
