package br.com.star.crudStar.controller;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.Post;
import br.com.star.crudStar.repository.PostRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PostController {

    private static final String NOT_FOUND = "Não foi encontrado uma pessoa com o id: ";

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
    @PatchMapping("/post/{id}")
    @ApiOperation("Atualiza o post")
    public ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long postId,
                                                @Valid @RequestBody Post postDetails) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + postId));

        post.setTexto(postDetails.getTexto());
        post.setUrl_foto(postDetails.getUrl_foto());

        final Post updatedPost = postRepository.save(post);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
    }
}
