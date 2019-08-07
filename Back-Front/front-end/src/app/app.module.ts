import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { httpInterceptorProviders } from './auth/auth-interceptor';
import { FooterComponent } from './shared/footer/footer.component';
import { HeaderComponent } from './shared/header/header.component';
import { PessoaCreateComponent } from './pessoa/pessoa-create/pessoa-create.component';
import { PessoaListComponent } from './pessoa/pessoa-list/pessoa-list.component';
import { PessoaDetailsComponent } from './pessoa/pessoa-details/pessoa-details.component';
import { PessoaEditComponent } from './pessoa/pessoa-edit/pessoa-edit.component';
import { PessoaSenhaComponent } from './pessoa/pessoa-senha/pessoa-senha.component';
import { PerfilComponent } from './perfil/perfil.component';
import { SobrenosComponent } from './sobrenos/sobrenos.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { PostCreateComponent } from './post/post-create/post-create.component';
import { PostListComponent } from './post/post-list/post-list.component';
import { ConfigurePagComponent } from './configure-pag/configure-pag.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    PessoaCreateComponent,
    PessoaListComponent,
    PessoaDetailsComponent,
    PessoaEditComponent,
    PessoaSenhaComponent,
    PerfilComponent,
    SobrenosComponent,
    UserDetailsComponent,
    PostCreateComponent,
    PostListComponent,
    ConfigurePagComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
