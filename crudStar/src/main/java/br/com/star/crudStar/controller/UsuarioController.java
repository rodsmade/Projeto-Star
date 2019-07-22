package br.com.star.crudStar.controller;

import br.com.star.crudStar.model.Usuario;
import br.com.star.crudStar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class UsuarioController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }


    @GetMapping("/usuario/{id}")
    public Optional<Usuario> findById(@PathVariable Long id){
        return usuarioRepository.findById(id);
    }
//    @GetMapping("/usuario/{id}")
//    public ResponseEntity<Usuario> getUsuarioId(@PathVariable(value = "id") Long usuarioId)
//            throws ResourceNotFoundException {
//        Usuario usuario = usuarioRepository.findById(usuarioId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + usuarioId));
//        return ResponseEntity.ok().body(usuario);
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuario")
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

//    @PutMapping("/usuario/{id}") //o nome que chamo o id é o mesmo que o id embaixo
//    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario)   //2 parâmetros
//            throws ResourceNotFoundException {
//        // "UPDATE cliente SET ... WHERE ..."
//        return usuarioRepository.findById(id).map(usuarioAtualizado -> {
//            usuarioAtualizado.set
//            clienteAtualizado.setEndereco(cliente.getEndereco());
//            clienteAtualizado.setDataNasc(cliente.getDataNasc());
//            return repository.save(clienteAtualizado);
//        }).orElseThrow(() ->
//                new ResourceNotFoundException("Não existe cliente cadastrado com o id: " + id));
//    }

//    @DeleteMapping("/usuario/{id}")
//    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long usuarioId)
//            throws ResourceNotFoundException {
//        Usuario usuario = usuarioRepository.findById(usuarioId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + usuarioId));
//
//        usuarioRepository.delete(usuario);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    //qual a diferença do delete de cima e do de baixo?
    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable Long id) {   //tudo que era integer a gnt começou a usar Long
        // "DELETE FROM clioente WHERE id = ..."
        usuarioRepository.deleteById(id);
    }
}
