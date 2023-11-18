import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
constructor(private router: Router){
  
}



  showSearchInput(): boolean {
    const allowedRoutes = ['/about', '/another-allowed-route']; // Add your allowed routes here
    return allowedRoutes.includes(this.router.url);
  }
}
