package br.com.star.crudStar.comentario;

import br.com.star.crudStar.CrudStarApplication;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

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
        this.token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY0Njg1MjE3LCJleHAiOjE1NjQ2ODYxMTd9.Tfjo_fz32ElEwp5HGPrESCWTmtKGwg5amwQCH8r1bJKVVj-rkW4P_2SHV6-hfl3h4bd4Y8zSLAGj5mFOGiJgAA"
    } 



}
