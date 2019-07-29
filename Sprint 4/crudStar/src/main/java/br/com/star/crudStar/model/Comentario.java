package br.com.star.crudStar.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
@ToString
@Data
@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @Column(name= "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;


    @NotNull
    private String comentario;
   }
