import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {TokenStorageService} from '../../auth/token-storage.service';
import {Router} from '@angular/router';
import {Post} from '../post';
import {PostService} from '../post.service';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css']
})
export class PostListComponent implements OnInit {
  posts: Observable<Post[]>;

  constructor(private token: TokenStorageService,
              private postService: PostService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.posts = this.postService.getPosts();
    console.log(this.posts);
  }

  adicionarPost() {
    this.router.navigate(['adicionar-post']);
  }

  deletarPost(id: number) {
    this.postService.deletarPost(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

}
