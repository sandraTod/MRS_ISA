import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {

  token: any;

  UserDTO = {
    username: null,
    name: null,
    lastname: null,
    address: null,
    city: null,
    state: null,
    phoneNum: null

  }

  constructor(private userService: UserService) { }

  ngOnInit(): void {

    this.getMe();

  }

getMe(){
  this.userService.getMe().subscribe(data => { console.log(data)})
}

}
