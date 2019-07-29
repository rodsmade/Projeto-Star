package br.com.star.crudStar.controller;

import br.com.star.crudStar.model.Post;
import br.com.star.crudStar.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @GetMapping("/post/{id}")
    public Optional<Post> findById(@PathVariable Long id) {
        return postRepository.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/post")
    public Post createPost(@Valid @RequestBody Post post){
        return postRepository.save(post);
    }

    //Update

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
    }
}
