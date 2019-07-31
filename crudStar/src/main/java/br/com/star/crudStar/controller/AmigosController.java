package br.com.star.crudStar.controller;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.Amigos;
import br.com.star.crudStar.model.Usuario;
import br.com.star.crudStar.repository.AmigosRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class AmigosController {

    private static final String NOT_FOUND = "Não foi encontrado um amigo com o id: ";

    @Autowired
    private AmigosRepository amigosRepository;

    public Amigos save(@RequestBody Amigos amigos){
        return amigosRepository.save(amigos);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/amigos")
    @ApiOperation("Lista amigos do usuário")
    public List<Amigos> buscarTodosAmigos() {
        return amigosRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    @ApiOperation("Busca um amigo")
    public ResponseEntity<Amigos> buscarAmigoPorId(@PathVariable(value = "id") Long amigosId)
            throws ResourceNotFoundException {
        Amigos amigos = amigosRepository.findById(amigosId)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + amigosId));
        return ResponseEntity.ok().body(amigos);
    }




}
