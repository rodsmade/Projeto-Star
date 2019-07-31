/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoaService } from '../pessoa.service';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'app-pessoa-details',
  templateUrl: './pessoa-details.component.html',
  styleUrls: ['./pessoa-details.component.css']
})
export class PessoaDetailsComponent implements OnInit {

  id: number;
  pessoa: Pessoa;

  constructor(private token: TokenStorageService,
              private route: ActivatedRoute,
              private router: Router,
              private pessoaService: PessoaService) { }

  ngOnInit() {
    this.pessoa = new Pessoa();

    this.id = this.route.snapshot.params['id'];

    this.pessoaService.getPessoa(this.id)
    .subscribe(data => {
      console.log(data)
      this.pessoa = data;
    }, error => console.log(error));
  }

  goToList() {
    this.router.navigate(['pessoas']);
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

}
