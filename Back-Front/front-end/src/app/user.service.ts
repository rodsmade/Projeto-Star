/* tslint:disable */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from './auth/token-storage.service';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/v1/user/me';
  private header = {Authorization: `Bearer ${this.token.getToken()}`};
  constructor(private http:HttpClient, private token: TokenStorageService) { }

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`, {headers: this.header});
  }
  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, user, {headers: this.header});
  }

  updateUser(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value, {headers: this.header});
  }

  deletarUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text', headers: this.header});
  }

  getUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}`, {headers: this.header});
  }
}
