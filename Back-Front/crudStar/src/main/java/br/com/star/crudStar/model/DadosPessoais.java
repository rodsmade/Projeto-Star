package br.com.star.crudStar.model;

import br.com.star.crudStar.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name = "dados_pessoais")

public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_dados_pessoais")
    private Long id;

    @Column(name = "url_foto_perfil", unique = true)
    @Size(max=100)
    private String url_foto_perfil;

    private String genero;

    private String cidade;

    @Column(name="cpf",unique = true)
    private BigInteger cpf;

    @Column(name = "cartao_credito",unique = true)
    private BigInteger cartaoCredito;

}
