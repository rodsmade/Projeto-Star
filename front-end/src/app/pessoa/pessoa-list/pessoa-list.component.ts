import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../pessoa';
import { Observable } from 'rxjs';
import { PessoaService } from '../pessoa.service';
import { Router } from '@angular/router';
import {TokenStorageService} from '../../auth/token-storage.service';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  pessoas: Observable<Pessoa[]>;

  constructor(private token: TokenStorageService,
              private pessoaService: PessoaService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.pessoas = this.pessoaService.getPessoas();
    console.log(this.pessoas);
  }

  adicionarPessoa() {
    this.router.navigate(['adicionar-pessoa']);
  }

  editarPessoa(id: number) {
    this.router.navigate(['editar-pessoa', id]);
  }

  visualizarPessoa(id: number) {
    this.router.navigate(['visualizar-pessoa', id]);
  }

  deletarPessoa(id: number) {
    this.pessoaService.deletarPessoa(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

}
