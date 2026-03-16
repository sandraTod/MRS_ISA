import { UserService } from './../../services/user.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerForm!: FormGroup;

constructor(private fb: FormBuilder, private userService: UserService){}

ngOnInit(){
  

  this.registerForm = this.fb.group({
    username: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required,Validators.minLength(6)]],
    confirmPassword: ['', Validators.required],
    name: ['', Validators.required],
    lastname: ['', Validators.required],
    address: ['', Validators.required],
    city: ['', Validators.required],
    state: ['', Validators.required],
    phoneNum: ['', Validators.required]
  }, {validators: this.passwordMatchValidator});

}

passwordMatchValidator(form: FormGroup){
  const password = form.get('password')?.value;
  const confirmPassword = form.get('confirmPassword')?.value;

  if(password === confirmPassword){
    return null;

  }
  return {passwordMismatch: true};


}

onSubmit(){

  if(this.registerForm.valid){

    const userData = this.registerForm.value;

    this.userService.register(userData).subscribe(()=>{
      alert("Uspesna registracija! Proveri svoj email za aktivaciju naloga!");
      this.registerForm.reset();
    })

  }

}

}
