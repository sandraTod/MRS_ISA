import { SubscriptionService } from './../../services/subscription.service';
import { Component, OnInit } from '@angular/core';
import { Adventure } from 'src/app/model/adventure';
import { AdventureService } from 'src/app/services/adventure.service';

@Component({
  selector: 'app-client-adventures',
  templateUrl: './client-adventures.component.html',
  styleUrls: ['./client-adventures.component.css']
})
export class ClientAdventuresComponent implements OnInit {

  adventureList!: any[];

  constructor(private adventureService: AdventureService, private subscriptionService: SubscriptionService) { }

  ngOnInit(): void {
    this.getAllAdventures();
  }

  getAllAdventures(){ 
    this.adventureService.getAllAdventures().subscribe(data => {
      this.adventureList= data.map(c=> ({
        ...c,
        isSubscribed: false
      }));
      console.log(this.adventureList); })
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
