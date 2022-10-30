import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../shared/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  // DI : Constructor Injection
  constructor(public usersService:UsersService) { }

  //Life Cycle Hook
  ngOnInit(): void
  {

  }

  //Submit Form
  onSubmit(form)
  {
    console.log(form.value);
    // return;
    this.insertUserRecord(form);
  }

  //Insert Method
  insertUserRecord(form?: NgForm)
  {
    console.log("Inserting a record");
    console.log(form.value);
    // return;
    this.usersService.insertUser(form.value).subscribe(
      (result) =>{

        localStorage.setItem("UserID",result.userID + "");
        console.log(result);
      }
    );
  }
}

