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

  toggleSubscription(resource: any) {

    if (resource.isSubscribed) {
      // ❌ UNSUBSCRIBE
      this.subscriptionService.unsubscribe(resource.type, resource.id).subscribe({
        next: () => {
          resource.isSubscribed = false;
        }
      });
  
    } else {
      // ✅ SUBSCRIBE
      this.subscriptionService.subscribe(resource.type, resource.id).subscribe({
        next: () => {
          resource.isSubscribed = true;
        }
      });
    }
  
  }


}
