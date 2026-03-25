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
  passwordError: string = '';

  updateForm = this.fb.group({
    username: [''],
    name: ['',Validators.required],
    lastname: ['', Validators.required],
    address: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    phoneNum: ['', Validators.required]
  });

  passwordForm = this.fb.group({
    oldPassword: ['', Validators.required],
    newPassword: ['',Validators.required, Validators.minLength(6)],
    confirmPassword: ['']
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

changePassword() {
  this.passwordError = '';

  if (!this.passwordsMatch()) {
    return;
  }

  const val = this.passwordForm.value;

  this.userService.changePassword({
    oldPassword: val.oldPassword,
    newPassword: val.newPassword
  }).subscribe({
    next: () => {
      console.log("Password changed");
      alert("Uspesno ste promenili lozinku!")

      this.passwordForm.reset(); 
    },
    error: (err) => {
      if (err.status === 400) {
        this.passwordError = "Old password is incorrect";
      } else {
        this.passwordError = "Something went wrong";
      }
    }
  });
}


passwordsMatch(): boolean {
  return this.passwordForm.value.newPassword === this.passwordForm.value.confirmPassword;
}

}
