import { Adventure } from './../model/adventure';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {

  constructor(private http:  HttpClient) { }

  getAllAdventures():Observable<Adventure[]>{
    return this.http.get<Adventure[]>("http://localhost:8080/api/adventure/getAllAdventures");
  }


  public filter(filter: any){

    let params = JSON.stringify(filter);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/api/adventure/filterAdventures", params,
      {
        headers: headers
      });

  }
}
