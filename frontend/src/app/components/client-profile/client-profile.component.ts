import { FormBuilder, Validators } from '@angular/forms';
import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/app/model/userDTO';

@Component({
  selector: 'app-client-profile',
  templateUrl: './client-profile.component.html',
  styleUrls: ['./client-profile.component.css']
})
export class ClientProfileComponent implements OnInit {

  token: any;
  
  updateForm = this.fb.group({
    username: [''],
    name: ['',Validators.required],
    lastname: ['', Validators.required],
    address: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    phoneNum: ['', Validators.required]
  });


  constructor(private userService: UserService, private fb: FormBuilder) { }

  ngOnInit(): void {

    this.getMe();

  }

getMe(){
  this.userService.getMe().subscribe((data : any) => {
    
    this.updateForm.patchValue(data);

  })
}

onSubmit(){
  this.userService.update(this.updateForm.value).subscribe(data=>{
    this.updateForm.patchValue(data);
    alert("Podaci uspesno izmenjeni!");
    
  })

}

}
