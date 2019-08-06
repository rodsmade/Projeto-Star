import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa';
import { PessoaService } from '../pessoa.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'app-pessoa-create',
  templateUrl: './pessoa-create.component.html',
  styleUrls: ['./pessoa-create.component.css']
})
export class PessoaCreateComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();

  constructor(private token: TokenStorageService,
              private pessoaService: PessoaService,
              private router: Router) { }

  ngOnInit() { }

  onSubmit() {
    this.pessoaService.createPessoa(this.pessoa)
    .subscribe(data => console.log(data), error => console.log(error));
    this.pessoa = new Pessoa();
    this.router.navigate(['pessoas']);
  }

  goToLogin() {
    this.router.navigate([('login')]);
  }

}
