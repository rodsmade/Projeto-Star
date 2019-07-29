package br.com.star.crudStar.controller;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.DadosPessoais;
import br.com.star.crudStar.repository.DadosPessoaisRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dados-pessoais")
public class DadosPessoaisController {

    @Autowired
    DadosPessoaisRepository repository;

    // CREATE
    // idealmente toda vez que alguém criar um perfil novo, um registro é automaticamente criado na tabela de dados pessoais
    // contendo valores nulos... TODO: rever o controller de cadastro de usuário
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/usuario")
    public DadosPessoais criarDadosPessoais(@RequestBody DadosPessoais dados) {
        return repository.save(dados);
    }

    // READ
    @GetMapping("/{id}")
    public DadosPessoais buscarDadosPessoaisPorId(@PathVariable Long id){
        return repository.findById(id).get();
    }

    // UPDATE
    @PatchMapping("/update/{id}")
    public void atualizarFotoPerfil(@RequestBody String urlFotoPerfil, @PathVariable Long id){
        repository.updateUrlFotoPerfilById(urlFotoPerfil, id);
    }

    @PutMapping("/update/{id}")
    @ApiOperation(value = "Operação para atualizar Cartão de Crédito, Cidade e gênero. Id, CPF e url da foto do perfil são desprezados nesta operação.")
    public DadosPessoais atualizarRegistroPorId(@PathVariable("id") Long id, @RequestBody DadosPessoais dados)
            throws ResourceNotFoundException {
        return repository.findById(id).map(d -> {
            d.setCartaoCredito(dados.getCartaoCredito());
            d.setCidade(dados.getCidade());
            d.setGenero(dados.getGenero());

            return repository.save(d);

        }).orElseThrow(
                () -> new ResourceNotFoundException("Não existe usuária cadastrada com o id: " + id));
    }

    // DELETE
    // Ao invés de deletar, vou setar os valores pra nulo
    @DeleteMapping("/delete/{id}")
    public void deletarPorId(@PathVariable Long id){
        repository.deleteById(id);
    }

}