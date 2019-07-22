package br.com.star.crudStar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer qtdAmigos;

    @NotBlank
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private String handle;
    private String email;
    private String senha;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", qtdAmigos=" + qtdAmigos +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", handle='" + handle + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
