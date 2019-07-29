package br.com.star.crudStar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@ EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
    public Docket comentsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.star.crudStar.demo"))
                .paths(regex("/comentario.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("API do Comentário")
                .description("\" API da documentação do comentário\"")
                .version("1.0.0")
                .license("Saturn Group 1.0.0")
                .licenseUrl("https://github.com/rdrggrgld/Projeto-Star\"")
                .contact(new Contact("Liliane Angelo", "https://github.com/rdrggrgld/Projeto-Star", "starcompany@star.com"))
                .build();
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}

