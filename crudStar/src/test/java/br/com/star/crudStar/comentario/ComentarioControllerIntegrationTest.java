package br.com.star.crudStar.comentario;

import br.com.star.crudStar.CrudStarApplication;
import br.com.star.crudStar.model.Comentario;
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
public class ComentarioControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api/v1/comentario/";
    }

    private String token;

   @Before
   public void init() {
        this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0Njg1MjE3LCJleHAiOjE1NjQ2ODYxMTd9.Tfjo_fz32ElEwp5HGPrESCWTmtKGwg5amwQCH8r1bJKVVj-rkW4P_2SHV6-hfl3h4bd4Y8zSLAGj5mFOGiJgAA";
    }

    @Test
    public void testaCriacaoDeUmNovoComentario() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Comentario> entity = new HttpEntity<>(ComentarioMock.getComentarioMock(), headers);

        ResponseEntity<Comentario> responseEntity = testRestTemplate.exchange(
                getRootUrl(),
                HttpMethod.POST,
                entity,
                Comentario.class
        );

        assertNotNull(responseEntity);
        assertEquals(201, responseEntity.getStatusCodeValue());
    }

    @Test
    public void testaConsultaDeTodosOsComentarios() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(
                getRootUrl(),
                HttpMethod.GET,
                entity,
                String.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testaConsultaComentarioPorId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<Comentario> response = testRestTemplate.exchange(
                getRootUrl() + "1",
                HttpMethod.GET,
                entity,
                Comentario.class);

        assertNotNull(response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testaAtualizacaoDeUmComentario() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer " + this.token);

        HttpEntity<Comentario> entity = new HttpEntity<>(ComentarioMock.getComentarioMock(), headers);

        ResponseEntity<Comentario> responseEntity = testRestTemplate.exchange(
                getRootUrl() + "1",
                HttpMethod.PUT,
                entity,
                Comentario.class
        );

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }





}
