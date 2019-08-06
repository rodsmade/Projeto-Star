/* tslint:disable */
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TokenStorageService } from '../auth/token-storage.service';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private baseUrl = 'http://localhost:8080/api/v1/post';
  private header = {Authorization: `Bearer ${this.token.getToken()}`};

  constructor(private http: HttpClient, private token: TokenStorageService) { }

  getPost(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`, {headers: this.header});
  }

  createPost(post: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, post, {headers: this.header});
  }

  updatePost(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value, {headers: this.header});
  }

  deletarPost(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType: 'text', headers: this.header});
  }

  getPosts(): Observable<any> {
    return this.http.get(`${this.baseUrl}`, {headers: this.header});
  }

}
