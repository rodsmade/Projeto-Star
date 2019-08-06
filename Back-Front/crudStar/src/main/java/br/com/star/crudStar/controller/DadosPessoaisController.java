package br.com.star.crudStar.controller;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import br.com.star.crudStar.model.DadosPessoais;
import br.com.star.crudStar.repository.DadosPessoaisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class DadosPessoaisController {

    @Autowired
    DadosPessoaisRepository dadosPessoaisRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/teste")
    @ApiOperation(value="Inserir novos dados pessoais",
            notes = "Insere um novo dado pessoal. Passe os valores no corpo da request.",
            response = DadosPessoais.class)
    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Inserido com sucesso!"),
            @ApiResponse(code = 401, message = "Sem autorização."),
            @ApiResponse(code = 403,message="Proibido."),
            @ApiResponse(code = 404,message="Recurso não encontrado."),
    })
    public DadosPessoais save(@RequestBody DadosPessoais dadosPessoais) {
        return dadosPessoaisRepository.save(dadosPessoais);
    }


    // CREATE
    // idealmente toda vez que alguém criar um perfil novo, um registro é automaticamente criado na tabela de dados pessoais
    // contendo valores nulos... TODO: rever o controller de cadastro de usuário
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/dados-pessoais")
    @ApiOperation(value = "Criar dados pessoais")
    public DadosPessoais criarDadosPessoais(@RequestBody DadosPessoais dados) {
        return dadosPessoaisRepository.save(dados);
    }

    // READ
    @GetMapping("/dados-pessoais/{id}")
    @ApiOperation("Busca dados pessoais")
    public DadosPessoais buscarDadosPessoaisPorId(@PathVariable Long id){
        return dadosPessoaisRepository.findById(id).get();
    }

    // UPDATE
    @PatchMapping("/dados-pessoais/{id}")
    @ApiOperation("Atualiza a foto de perfil")
    public void atualizarFotoPerfil(@RequestBody String url_foto_perfil, @PathVariable Long id){
        dadosPessoaisRepository.updateUrlFotoPerfilById(url_foto_perfil, id);
    }

    @PutMapping("/dados-pessoais/{id}")
    @ApiOperation(value = "Operação para atualizar Cartão de Crédito, Cidade e gênero. Id, CPF e url da foto do perfil são desprezados nesta operação.")
    public DadosPessoais atualizarRegistroPorId(@PathVariable(value ="id") Long id, @RequestBody DadosPessoais dados)
            throws ResourceNotFoundException {
        return dadosPessoaisRepository.findById(id).map(d -> {
            d.setCartaoCredito(dados.getCartaoCredito());
            d.setCidade(dados.getCidade());
            d.setGenero(dados.getGenero());
            return dadosPessoaisRepository.save(d);

        }).orElseThrow(
                () -> new ResourceNotFoundException("Não existe usuário cadastrado com o id: " + id));
    }

    // DELETE
    // Ao invés de deletar, vou setar os valores pra nulo
    @DeleteMapping("/dados-pessoais/{id}")
    @ApiOperation(value= "Deleta dados pessoais")
    public void deletarPorId(@PathVariable Long id){
        dadosPessoaisRepository.deleteById(id);
    }

}