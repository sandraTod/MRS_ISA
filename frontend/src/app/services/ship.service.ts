import { HttpClient } from '@angular/common/http';
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
}
