import {Component, OnInit} from '@angular/core';
import { TokenStorageService } from '../auth/token-storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private token: TokenStorageService, private router: Router) { }

  ngOnInit() { }

  goToLogin() {
    this.router.navigate([('login')]);
  }

}
