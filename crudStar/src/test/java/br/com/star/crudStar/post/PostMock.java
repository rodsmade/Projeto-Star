package br.com.star.crudStar.post;

import br.com.star.crudStar.model.Comentario;
import br.com.star.crudStar.model.Post;
import com.github.javafaker.Faker;

import java.util.Locale;

public class PostMock {
    public static Post getPostMock() {
        Post post = new Post();
        Faker faker = new Faker(new Locale("pt-BR"));
        post.setTexto(faker.lorem().sentence());
        post.setUrl_foto(faker.lorem().sentence());
        post.setUrl_video(faker.lorem().sentence());

        return post;
    }
}
