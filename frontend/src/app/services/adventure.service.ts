import { Adventure } from './../model/adventure';
import { HttpClient } from '@angular/common/http';
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
}
