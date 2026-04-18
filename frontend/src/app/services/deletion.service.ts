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

  getAll() {
    return this.http.get<any[]>("http://localhost:8080/api/deletionRequest/getAll");
  }

  respond(id: number, dto: any){
    return this.http.put("http://localhost:8080/api/deletionRequest/respond/"+ id , dto, {})

  }
}
