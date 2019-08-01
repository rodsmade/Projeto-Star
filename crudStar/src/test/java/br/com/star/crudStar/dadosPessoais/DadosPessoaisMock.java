package br.com.star.crudStar.dadosPessoais;

import br.com.star.crudStar.model.Comentario;
import br.com.star.crudStar.model.DadosPessoais;
import com.github.javafaker.Faker;

import java.util.Locale;

public class DadosPessoaisMock {


    public static DadosPessoais getDadosPessoaisMock() {
        DadosPessoais dadosPessoais = new DadosPessoais();
        Faker faker = new Faker(new Locale("pt-BR"));
        dadosPessoais.setCartaoCredito(faker.number().randomNumber();
        dadosPessoais.setCidade(faker.lorem().sentence());
        dadosPessoais.setGenero(faker.lorem().sentence());
        dadosPessoais.setUrl_foto_perfil(faker.lorem().sentence());

        return dadosPessoais;
    }
}
