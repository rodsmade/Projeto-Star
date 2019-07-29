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
@Table(name = "dados_pessoais")

public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dados_pessoais")
    private Long id;

    @Column(name = "url_foto_perfil")
    @Size(max=100)
    private String url_foto_perfil;

    private String genero;

    private String cidade;

    @Column(name="cpf",unique = true)
    private BigInteger cpf;

    @Column(name = "cartao_credito",unique = true)
    private BigInteger cartaoCredito;

}
