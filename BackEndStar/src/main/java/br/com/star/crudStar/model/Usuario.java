package br.com.star.crudStar.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@ToString
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer qtdAmigos;
    // conferir banco de dados
    @NotBlank
    private String nome;
    private String sobrenome;
    private Date nascimento;
    private String handle;
    private String email;
    private String senha;


    }

