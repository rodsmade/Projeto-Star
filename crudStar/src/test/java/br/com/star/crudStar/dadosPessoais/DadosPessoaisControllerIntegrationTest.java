package br.com.star.crudStar.dadosPessoais;

import br.com.star.crudStar.CrudStarApplication;

import br.com.star.crudStar.model.DadosPessoais;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrudStarApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DadosPessoaisControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api/v1/dados-pessoais/";
    }

    private String token;

    @Before
    public void init() {
        this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0NzY4NTI3LCJleHAiOjE1NjQ4NTQ5Mjd9.L-u1pAhdJmU3jq2_FRxm4_LhuanznrFl1kqP8fLYEJ1w45rKaQEUNld_4-xP0k-ikvlgxQ0-EYQCP3TVDcwvFQ";
    }

    @Test
    public void testaCriacaoDeUmNovoDadoPessoal() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<DadosPessoais> entity = new HttpEntity<>(DadosPessoaisMock.getDadosPessoaisMock(), headers);

        ResponseEntity<DadosPessoais> responseEntity = testRestTemplate.exchange(
                getRootUrl(),
                HttpMethod.POST,
                entity,
                DadosPessoais.class
        );

        assertNotNull(responseEntity);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }


    @Test
    public void testaConsultaDadosPessoaisPorId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<DadosPessoais> response = testRestTemplate.exchange(
                getRootUrl() + "1",
                HttpMethod.GET,
                entity,
                DadosPessoais.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testaAtualizacaoDeUmDadoPessoal() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<DadosPessoais> entity = new HttpEntity<>(DadosPessoaisMock.getDadosPessoaisMock(), headers);

        ResponseEntity<DadosPessoais> responseEntity = testRestTemplate.exchange(
                getRootUrl() + "1",
                HttpMethod.PATCH,
                entity,
                DadosPessoais.class
        );

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }



}
