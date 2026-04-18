import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DeletionService {

  constructor(private http: HttpClient) { }


  create(dto: any){

    return this.http.post("http://localhost:8080/api/deletionRequest/create/",dto)
  }
}
