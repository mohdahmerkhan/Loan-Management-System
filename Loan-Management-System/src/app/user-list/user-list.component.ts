import { Component, OnInit } from '@angular/core';
import { UsersService } from '../shared/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  constructor(public usersService : UsersService) { }

  ngOnInit(): void
  {
    console.log("Welcome to the LifeCycle Hook");
    this.usersService.bindGetAllUsersList();
  }

  //Subscribe getAllUsers
  getAllUsersList()
  {
    //Call Service
    this.usersService.getAllUSers().subscribe(
      response => {
        console.log("Retrieving from list");
        console.log(response);
      },
      (error) =>{
        console.log("Something Wrong");
        console.log(error);
      }
    )
  }
}
