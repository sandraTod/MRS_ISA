import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cottage } from '../model/cottage';

@Injectable({
  providedIn: 'root'
})
export class CottageService {

  constructor(private http: HttpClient) { }

  getAllCottages():Observable<Cottage[]>{
    return this.http.get<Cottage[]>("http://localhost:8080/api/cottage/getAllCottages");
  }

  
  public filter(filter: any){

    let params = JSON.stringify(filter);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/api/cottage/filterCottages", params,
      {
        headers: headers
      });

  }
}
