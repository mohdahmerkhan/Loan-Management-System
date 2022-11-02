import { Component, OnInit, resolveForwardRef } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Loan-Management-System';
  role = 0 ;// 0 means public
  
  ngOnInit(): void 
  {
    if( localStorage.getItem("ACCESS_ROLE") == null)
    {
      this.role = 0;
    }
    else
    {
      this.role =localStorage.getItem("ACCESS_ROLE") as unknown as number; 
    }    
  }
   
}
