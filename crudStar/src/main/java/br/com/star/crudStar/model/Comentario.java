package br.com.star.crudStar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
