import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators,
  FormGroup,
  FormControl,
} from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  email: string = '';
  password: string = '';
  username: string = '';
  constructor(private router: Router, public FormBuilder: FormBuilder, private service: AuthService) { }
  ngOnInit() { }

  public register() {
    let response = this.service.Register(this.email,this.password,this.username);
    response.subscribe((res) => {
      console.log(res);
      alert(" signup done  successfully")
    }, (err) => {
      console.log(err);
      alert(" signup failed  successfully")
    })
  }



}

