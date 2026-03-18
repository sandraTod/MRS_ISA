import { HttpClient } from '@angular/common/http';
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
}
