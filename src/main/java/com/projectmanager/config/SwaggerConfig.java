package com.projectmanager.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI projectManagerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Project Manager API")
                        .description("API para gerenciamento de projetos e tarefas — construída passo a passo com boas práticas em Java e Spring Boot.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Diogenes Pereira Soares")
                                .email("diosoaresdev@gmail.com")
                                .url("https://github.com/DioSoares/projectmanager"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação completa do projeto")
                        .url("https://github.com/DioSoares/projectmanager"));

    }
}
