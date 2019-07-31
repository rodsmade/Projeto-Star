import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PessoaListComponent } from './pessoa/pessoa-list/pessoa-list.component';
import { PessoaCreateComponent } from './pessoa/pessoa-create/pessoa-create.component';
import { PessoaEditComponent } from './pessoa/pessoa-edit/pessoa-edit.component';
import { PessoaDetailsComponent } from './pessoa/pessoa-details/pessoa-details.component';
import { PessoaSenhaComponent } from './pessoa/pessoa-senha/pessoa-senha.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'pessoas',
    component: PessoaListComponent
  },
  {
    path: 'adicionar-pessoa',
    component: PessoaCreateComponent
  },
  {
    path: 'editar-pessoa/:id',
    component: PessoaEditComponent
  },
  {
    path: 'visualizar-pessoa/:id',
    component: PessoaDetailsComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'signup',
    component: RegisterComponent
  },
  {
  path: 'senha',
  component: PessoaSenhaComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
