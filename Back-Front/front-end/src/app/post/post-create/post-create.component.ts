import { Component, OnInit } from '@angular/core';
import { Post } from '../post';
import { PostService } from '../post.service';
import { Router } from '@angular/router';
import { TokenStorageService } from '../../auth/token-storage.service';

@Component({
  selector: 'app-post-create',
  templateUrl: './post-create.component.html',
  styleUrls: ['./post-create.component.css']
})
export class PostCreateComponent implements OnInit {
  post: Post = new Post();

  constructor(private token: TokenStorageService,
              private postService: PostService,
              private router: Router) { }

  ngOnInit() {}

  onSubmit() {
    this.postService.createPost(this.post)
      .subscribe(data => console.log(data), error => console.log(error));
    this.post = new Post();
    this.router.navigate(['home']);
  }


  goToLogin() {
    this.router.navigate(['login']);
  }

}
