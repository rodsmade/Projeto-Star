package br.com.star.crudStar.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Data
@Entity
@Table(name = "Post")
public class Post {

    @Id
    @Column(name = "id_post")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //conferir se as classes dos atributos estão corretas
    //principalmente para Foto e Video
    @Column(name = "texto")
    private String texto;
    @Column(name = "url_video")
    private String url_video;
    @Column(name = "url_foto")
    private String url_foto;

}
