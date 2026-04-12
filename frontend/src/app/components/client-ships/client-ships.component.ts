import { Component, OnInit } from '@angular/core';
import { Ship } from 'src/app/model/ship';
import { ShipService } from 'src/app/services/ship.service';
import { SubscriptionService } from 'src/app/services/subscription.service';

@Component({
  selector: 'app-client-ships',
  templateUrl: './client-ships.component.html',
  styleUrls: ['./client-ships.component.css']
})
export class ClientShipsComponent implements OnInit {

  shipList!: any[];
  
  constructor(private shipService: ShipService, private subscriptionService: SubscriptionService) { }

  ngOnInit(): void {
    this.getAllShips();
  }


  getAllShips(){ 
    this.shipService.getAllShips().subscribe(data => {

      this.shipList = data.map(c=> ({
        ...c,
        isSubscribed: false
      }));
      console.log(this.shipList); })
  }

  subscribe( ship: any) {
    this.subscriptionService.subscribe(ship.type,ship.id).subscribe({
      next: () => {
        alert("Subscribed! 🎉");
        ship.isSubscribed = true;
      },
      error: () => {
        alert("Error 😢");
      }
    });
  }


}
