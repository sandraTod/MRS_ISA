import { SubscriptionService } from 'src/app/services/subscription.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-subscriptions',
  templateUrl: './subscriptions.component.html',
  styleUrls: ['./subscriptions.component.css']
})
export class SubscriptionsComponent implements OnInit {

  constructor(private subscriptionService: SubscriptionService) { }

  subscriptions: any[] = [];

ngOnInit() {
  this.loadSubscriptions();
}

loadSubscriptions() {
  this.subscriptionService.getSubscriptions().subscribe(res => {
    this.subscriptions = res;
  });
}

unsubscribe(s: any) {
  this.subscriptionService.unsubscribe(s.type, s.id).subscribe(() => {
    this.loadSubscriptions(); // refresh 🔥
  });
}

}
