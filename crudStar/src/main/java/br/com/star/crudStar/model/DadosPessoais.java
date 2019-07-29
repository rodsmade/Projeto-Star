package br.com.star.crudStar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dados_pessoais")
    private Long id;

    @Column(name = "url_foto_perfil")
    @Size(max=100)
    private String urlFotoPerfil;

    private String genero;

    private String cidade;

    @Column(name="CPF",unique = true)
    private BigInteger cpf;

    @Column(name = "cartao_credito",unique = true)
    private BigInteger cartaoCredito;

}
