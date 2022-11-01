import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { CustomerComponent } from './customer/customer.component';
import { OfficerComponent } from './officer/officer.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { AboutusComponent } from './home/aboutus/aboutus.component';
import { ContactusComponent } from './home/contactus/contactus.component';
import { UserListComponent } from './user-list/user-list.component';
import { LoanRequestListComponent } from './loan-request-list/loan-request-list.component';
import { LoanComponent } from './loan/loan.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    CustomerComponent,
    OfficerComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    PagenotfoundComponent,
    AboutusComponent,
    ContactusComponent,
    UserListComponent,
    LoanRequestListComponent,
    LoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
