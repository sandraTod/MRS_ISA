import { ChangePasswordDTO} from './../model/changePasswordDTO';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegisterRequest } from 'src/app/model/register-request';
import { UpdateUserDTO } from '../model/updateUserDTO';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  public authenticate(username: string, password: string) {
    let authenticationRequest = { username: username, password: password };
    let params = JSON.stringify(authenticationRequest);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/auth", params,
      {
        headers: headers
      });
  }

  public register(userData: RegisterRequest){

    let params = JSON.stringify(userData);
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    console.log(headers);
    return this.http.post("http://localhost:8080/api/user/registerUser", params,
      {
        headers: headers
      });

  }

  public getMe() {

    const token = localStorage.getItem('loggedUser');
    console.log(token);
    
    let headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
    return this.http.get('http://localhost:8080/api/user/getCurrentUser', {
      headers: headers
    });
  }

  public update(updateUser : UpdateUserDTO){

    const token = localStorage.getItem('loggedUser');
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8').set('Authorization', `Bearer ${token}`);
    return this.http.put('http://localhost:8080/api/user/updateUser',updateUser, {
      headers: headers
    });

  }

  public changePassword(changed: ChangePasswordDTO){
    const token = localStorage.getItem('loggedUser');
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8').set('Authorization', `Bearer ${token}`);
    return this.http.patch('http://localhost:8080/api/user/changePassword',changed, {
      headers: headers
    });

  }

}
