import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { CustomerComponent } from './customer/customer.component';
import { AboutusComponent } from './home/aboutus/aboutus.component';
import { ContactusComponent } from './home/contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { LoginComponent } from './login/login.component';
import { OfficerComponent } from './officer/officer.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { LoanRequest } from './shared/loan-request';
import { SignupComponent } from './signup/signup.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  {path:'admin',component:AdminComponent},
  {path:'customer',component:CustomerComponent},
  {path:'home',component:HomeComponent},
  {path:'loan',component:LoanComponent},
  {path:'loan-request',component:LoanRequest},
  {path:'login',component:LoginComponent},
  {path:'officer',component:OfficerComponent},
  {path:'pagenotfount',component:PagenotfoundComponent},
  {path:'signup',component:SignupComponent},
  {path:'user-list',component:UserListComponent},
  {path:'about-us',component:AboutusComponent},
  {path:'contact-us',component:ContactusComponent},
  {path:'**',component:HomeComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
