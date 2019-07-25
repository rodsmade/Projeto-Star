package br.com.star.crudStar.demo.webTeste;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "postagens")
public class PostagemController {

    @ApiOperation(value = "Comentários postados")
    @GetMapping(value = "/comentario", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Postagem(@RequestParam(required = false) boolean ) {
        Greeting  new Greeting("Hello world");
        if (niteroi) {
            greeting.setMessage(greeting.getMessage().replace("world", "Niteroi"));
        }
        return greeting;
    }

    @ApiOperation(value = "Greets a person given her name")
    @GetMapping(value = "/hello/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Greeting get(@PathVariable String name) {
        return new Greeting("Hello, " + name);
    }
}

