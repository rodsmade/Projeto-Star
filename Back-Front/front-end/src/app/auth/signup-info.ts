export class SignUpInfo {

  name: string;
  username: string;
  email: string;
  password: string;
  nascimento: string;
  sobrenome: string;

  constructor(name: string, username: string, email: string, password: string, nascimento: string, sobrenome: string ) {
    this.name = name;
    this.username = username;
    this.email = email;
    this.password = password;
    this.nascimento = nascimento;
    this.sobrenome = sobrenome;
  }

}
