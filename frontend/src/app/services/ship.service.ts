import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Ship } from '../model/ship';

@Injectable({
  providedIn: 'root'
})
export class ShipService {

  constructor(private http : HttpClient) { }

  getAllShips():Observable<Ship[]>{
    return this.http.get<Ship[]>("http://localhost:8080/api/ship/getAllShips");
  }


  public filter(filter: any){

    let params = JSON.stringify(filter);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/api/ship/filterShips", params,
      {
        headers: headers
      });

  }
}
