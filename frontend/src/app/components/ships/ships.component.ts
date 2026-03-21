import { Component, OnInit } from '@angular/core';
import { Ship } from 'src/app/model/ship';
import { ShipService } from 'src/app/services/ship.service';

@Component({
  selector: 'app-ships',
  templateUrl: './ships.component.html',
  styleUrls: ['./ships.component.css']
})
export class ShipsComponent implements OnInit {

  shipList!: Ship[];

  filter = {
    name: null,
    city: null,
    minGrade: null,

  }

  constructor( private shipService: ShipService) { }

  ngOnInit(): void {
    this.getAllShips();
  }


  getAllShips(){ 
    this.shipService.getAllShips().subscribe(data => {
      this.shipList = data; 
      console.log(this.shipList); })
  }

  filterShip(){
    console.log(this.filter);
    this.shipService.filter(this.filter).subscribe((data: any) => { this.shipList = data;console.log(data)})
  }
  reset() {
    this.filter = {
      name: null,
      city: null,
      minGrade: null
    };
    this.getAllShips(); // vrati sve
  }

}
