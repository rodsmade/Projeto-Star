package br.com.star.crudStar.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@Entity
public class DadosPessoais {

    @Id
    @Column(name="id_dados_pessoais")
    private Integer id;

    @Column(name = "url_foto_perfil")
    @Size(max=100)
    private String urlFotoPerfil;

    private String genero;

    private String cidade;

    @Column(unique = true)
    private BigInteger cpf;

    @Column(name = "cartao_credito",unique = true)
    private BigInteger cartaoDeCredito;

}
