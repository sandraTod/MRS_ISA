import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {

  constructor(private http: HttpClient) { }


  public createComplaint(dto: any){
      let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
      return this.http.post("http://localhost:8080/api/complaint/create/", dto,
        {
          headers: headers
        })
    

  }
}
