package com.forumhub.infra.springdoc;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Fórum Hub Api")
                        .description("API Rest da aplicação Fórum Hub, contendo as funcionalidades de CRUD de tópicos, usuários e respostas dos tópicos.")
                        .contact(new Contact()
                                .name("Emanuel")
                                .url("https://www.linkedin.com/in/emanuel-de-jesus-nardes-computer-engineer/"))
                .license(new License()
                        .name("MIT")
                        .url("https://github.com/emanueljn/forumhub/blob/main/LICENSE")));
    }
}
