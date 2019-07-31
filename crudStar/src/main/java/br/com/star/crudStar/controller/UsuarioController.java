package br.com.star.crudStar.controller;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.DadosPessoais;
import br.com.star.crudStar.model.Usuario;
import br.com.star.crudStar.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/v1")
public class UsuarioController {

    private static final String NOT_FOUND = "Não foi encontrado um usuário com o id: ";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }


    // Método READ
    @GetMapping("/usuario")
    @ApiOperation("Busca usuários")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    @ApiOperation("Busca um usuário")
    public ResponseEntity<Usuario> getUsuarioId(@PathVariable(value = "id") Long usuarioId)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
               .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }
    //------------------------------------------------------------------------------------------------------------------
    // Método CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuario")
    @ApiOperation(value = "Criar usuário")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //------------------------------------------------------------------------------------------------------------------

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Usuario> updatePessoa(@PathVariable(value = "id") Long pessoaId,
                                               @Valid @RequestBody Usuario usuarioDetails) {
        Usuario usuario = null;
        try {
            usuario = usuarioRepository.findById(pessoaId)
                     .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + pessoaId));
        } catch (ResourceNotFoundException e) {
            e.printStackTrace();
        }

        usuario.setNome(usuarioDetails.getNome());
        usuario.setSobrenome(usuarioDetails.getSobrenome());

        final Usuario updatedUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @DeleteMapping("/usuario/{id}")
    @ApiOperation("Deleta usuário por id")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long usuarioId)
            throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + usuarioId));

        usuarioRepository.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
