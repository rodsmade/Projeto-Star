import { Injectable } from '@angular/core';

const TOKEN_KEY = 'AuthToken';
const TOKEN_TYPE = 'AuthTokenType';
const ROLE_TYPE = 'AuthRoleType';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut() {
    localStorage.clear();
  }

  public saveToken(token: string) {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): string {
    return localStorage.getItem(TOKEN_KEY);
  }

  public saveTokenType(tokenType: string) {
    localStorage.removeItem(TOKEN_TYPE);
    localStorage.setItem(TOKEN_TYPE, tokenType);
  }

  public getTokenType(): string {
    return localStorage.getItem(TOKEN_TYPE);
  }

  public saveRoleType(roleType: string) {
    localStorage.removeItem(ROLE_TYPE);
    localStorage.setItem(ROLE_TYPE, roleType);
  }

  public getRoleType(): string {
    return localStorage.getItem(ROLE_TYPE);
  }

}
