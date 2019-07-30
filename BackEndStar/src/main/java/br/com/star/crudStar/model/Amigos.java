package br.com.star.crudStar.model;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Table(name = "amigos")
public class Amigos {

    @Id
    @Column(name = "id_amizade")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Id
    @Column(name = "id_convite")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConvite;

    @Id
    @Column(name = "id_convidado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConvidado;

    }
