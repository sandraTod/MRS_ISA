import { SubscriptionService } from './../../services/subscription.service';
import { CottageService } from './../../services/cottage.service';
import { Component, OnInit } from '@angular/core';
import { Cottage } from 'src/app/model/cottage';

@Component({
  selector: 'app-client-cottages',
  templateUrl: './client-cottages.component.html',
  styleUrls: ['./client-cottages.component.css']
})
export class ClientCottagesComponent implements OnInit {

  cottageList!: any[];


  constructor(private cottageService: CottageService, private subscriptionService: SubscriptionService) { }

  ngOnInit(): void {
     
    this.getAllCottages();

    

  }
  getAllCottages(){
    
    this.cottageService.getAllCottages().subscribe(data => {

      this.cottageList = data.map(c=> ({
        ...c,
        isSubscribed: false
      }));
      console.log(this.cottageList); })
  }


  subscribe( cottage: any) {
    this.subscriptionService.subscribe(cottage.type,cottage.id).subscribe({
      next: () => {
        alert("Subscribed! 🎉");
        cottage.isSubscribed = true;
      },
      error: () => {
        alert("Error 😢");
      }
    });
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
