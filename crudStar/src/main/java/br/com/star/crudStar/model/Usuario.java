package br.com.star.crudStar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer qtdAmigos;

    @NotBlank
    private String nome;
    private String sobrenome;
    //dataNascimento
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
