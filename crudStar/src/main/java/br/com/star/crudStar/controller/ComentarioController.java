package br.com.star.crudStar.controller;


import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.Comentario;
import br.com.star.crudStar.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @DeleteMapping("/comentario/{id}")
    public Map<String, Boolean> deletarComentario(@PathVariable(value = "id") Long comentarioId)
            throws ResourceNotFoundException {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + comentarioId));

        comentarioRepository.delete(comentario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }







}

