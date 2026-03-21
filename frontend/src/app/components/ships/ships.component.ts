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

  constructor( private shipService: ShipService) { }

  ngOnInit(): void {
    this.getAllShips();
  }


  getAllShips(){ 
    this.shipService.getAllShips().subscribe(data => {
      this.shipList = data; 
      console.log(this.shipList); })
  }

}
