import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { LoginDTO } from './login-dto';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // //Global Variable
  // // formUserData: User = new User();

  // //List of Users -- Retrieve all Records
  // users: User[] = []; //All Users
  // roles: Role[] = []; //All Roles
  isLoggedIn : boolean = false;

  constructor(private httpClient: HttpClient, private router: Router) {

  }

  // Get Email or Phone & Password
  getEmailPhoneAndPassword(loginDTO:LoginDTO): Observable<any>
  {
    console.log(loginDTO.emailOrPhone);
    console.log(loginDTO.password);
    //  http://localhost:9095/api/userLogin/{emailOrPhone}&{password}
    return this.httpClient.get(environment.apiUrl + "api/userLogin/" + loginDTO.emailOrPhone + "&" + loginDTO.password);
  }
  
  // Log Out Service Method
  public logOut()
  {
    localStorage.removeItem("USERNAME");
    localStorage.removeItem("ACCESSROLE");
    localStorage.removeItem("isLoggedIn");
    // this.isLoggedIn = false;
  }

  isLogged(){
    if(localStorage.getItem("isLoggedIn")===null)
      return false
    else
      return true
  }
}

