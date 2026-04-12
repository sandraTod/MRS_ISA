import { Component, OnInit } from '@angular/core';
import { Ship } from 'src/app/model/ship';
import { ShipService } from 'src/app/services/ship.service';

@Component({
  selector: 'app-client-ships',
  templateUrl: './client-ships.component.html',
  styleUrls: ['./client-ships.component.css']
})
export class ClientShipsComponent implements OnInit {

  shipList!: Ship[];
  
  constructor(private shipService: ShipService) { }

  ngOnInit(): void {
    this.getAllShips();
  }


  getAllShips(){ 
    this.shipService.getAllShips().subscribe(data => {
      this.shipList = data; 
      console.log(this.shipList); })
  }


}
