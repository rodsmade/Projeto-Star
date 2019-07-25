package br.com.star.crudStar.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Override
    public String toString() {
        return "Comentario{" +
                "idComentario=" + idComentario +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
