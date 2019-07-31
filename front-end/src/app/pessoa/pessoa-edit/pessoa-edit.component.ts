/* tslint:disable */
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { PessoaService } from '../pessoa.service';
import { Pessoa } from '../pessoa';
import { first } from 'rxjs/operators';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'app-pessoa-edit',
  templateUrl: './pessoa-edit.component.html',
  styleUrls: ['./pessoa-edit.component.css']
})
export class PessoaEditComponent implements OnInit {

  pessoa: Pessoa;
  editForm: FormGroup;

  constructor(private token: TokenStorageService,
              private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private pessoaService: PessoaService) { }

  ngOnInit() {
    let pessoaId = this.route.snapshot.params['id'];
    if(!pessoaId) {
      alert("Ação inválida!")
      this.router.navigate(['pessoas']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [],
      nome: ['', Validators.required],
      sobrenome: ['', Validators.required],
      cidade: ['', Validators.required]
    });
    this.pessoaService.getPessoa(pessoaId)
    .subscribe( data => {
      this.editForm.setValue(data);
    });
  }

  onSubmit() {
    let pessoaId = this.route.snapshot.params['id'];
    this.pessoaService.updatePessoa(pessoaId, this.editForm.value)
    .pipe(first())
    .subscribe(
      data => {
        this.router.navigate(['pessoas']);
      },
      error => {
        alert(error);
      });
  }

  goToLogin() {
    this.router.navigate(['login']);
  }

}
