import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-configure-pag',
  templateUrl: './configure-pag.component.html',
  styleUrls: ['./configure-pag.component.css']
})
export class ConfigurePagComponent implements OnInit {

  constructor( private router: Router) { }

  ngOnInit() {
  }

}
