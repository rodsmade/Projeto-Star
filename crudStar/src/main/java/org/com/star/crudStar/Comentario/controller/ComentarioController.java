package org.com.star.crudStar.Comentario.controller;

import org.com.star.crudStar.Comentario.model.Comentario;
import org.com.star.crudStar.Comentario.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;


    @GetMapping("/comentario")
    public List<Comentario> visualizarTodosComentarios(){
        return comentarioRepository.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/comentario")
    public Comentario criarComentario(@Valid @RequestBody Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    @PutMapping("/comentario/{id}") //o nome que chamo o id é o mesmo que o id embaixo
      public Comentario atualizarComentarios(@PathVariable Long id, @RequestBody Comentario comentario)
            throws ResourceNotFoundException {
        // "UPDATE cliente SET ... WHERE ..."
        return comentarioRepository.findById(id).map(comentarioAtualizado -> {
           comentarioAtualizado.setComentario(comentario.getComentario());
            return comentarioRepository.save(comentarioAtualizado);
        }).orElseThrow(() ->
                new ResourceNotFoundException("Não existe comentário salvo com o id: " + id));
    }







}
