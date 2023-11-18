import { Component, OnInit, Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';



import {
  FormBuilder,
  ReactiveFormsModule,
  Validators,
  FormGroup,
  FormControl,
} from '@angular/forms';

import { from } from 'rxjs';

@Component({
  selector: 'app-welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.css']
})
export class WelcomePageComponent {
  aa = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$";

  constructor(private router: Router, private FormBuilder: FormBuilder, private service: AuthService) { }
  ngOnInit(): void { }

  username: string = '';
  password: string = '';
  errorMessage: string = '';

  emailRegex =
    /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/;
  visible: boolean = true;
  changetype: boolean = true;

  view() {
    this.visible = !this.visible;
    this.changetype = !this.changetype;
  }
  form: any;
  login() {
    let response = this.service.login(this.username, this.password);
    response.subscribe(
      (user) => {
        console.log(this.username);
        console.log(this.password);
        alert("login done successfully !");
        console.log(user);
        localStorage.setItem('email', this.username);
        localStorage.setItem('password', this.password);
        this.router.navigate(['/Employee']);
      },
      (error) => {
        console.log(this.username);
        console.log(this.password);
        alert(" login failed successfully !")
        this.router.navigate(['/login']);
        console.log(error);
        this.errorMessage = 'Invalid credentials. Please try again !.';
      }
    );
  }
}
