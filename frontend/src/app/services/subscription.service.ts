import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SubscriptionService {

  constructor(private http: HttpClient) { }

  
  subscribe(type: string, id: number) {
    return this.http.post(
      "http://localhost:8080/api/subscriptions/subscribe/"+type+"/"+ id,{}
    );
  }
}
