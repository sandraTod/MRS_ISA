import { ReservationRequest } from 'src/app/model/reservation-request';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  public search(searchData: any){


    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/api/search/searchEntities", searchData,
      {
        headers: headers
      });

  }
 public calculatePrice(request: any) {
    return this.http.post<number>('http://localhost:8080/api/reservation/calculatePrice', request);
  }

  public createReservation(reservationReq: ReservationRequest){
    const clientId = 2
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post("http://localhost:8080/api/reservation/createReservation/"+ clientId, reservationReq,
      {
        headers: headers
      })
  }

  getMyReservations() {
    const clientId = 2
    return this.http.get<any[]>("http://localhost:8080/api/reservation/getClientReservations/"+ clientId );
  }

  cancelReservation(id: number) {
    return this.http.post("http://localhost:8080/api/reservation/cancelReservation/"+ id, {});
  }

  getFastReservations(type: string){
    return this.http.get<any[]>("http://localhost:8080/api/availiability/getFastReservations?type="+type);
  }

  reserveFast(id: number) {
    return this.http.post("http://localhost:8080/api/availiability/reserveFast/"+id, {});
  }

}
