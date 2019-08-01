package br.com.star.crudStar.comentario;

import br.com.star.crudStar.model.Comentario;
import com.github.javafaker.Faker;

import java.util.Locale;

public class ComentarioMock {

    public static Comentario getComentarioMock() {
        Comentario comentario = new Comentario();
        Faker faker = new Faker(new Locale("pt-BR"));
        comentario.setComentario(faker.lorem().sentence());

        return comentario;
    }



}
