package org.projeto.tde.projetoemprestimotde.infra.springdoc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API do Sistema de Empréstimos TrackBug")
                        .description("Esta é a API do back-end do Sistema de Empréstimos TrackBug, um projeto da matéria de Programação Orientada a Objetos da Faculdade UNIFAN voltado para o TDE. A API permite gerenciar empréstimos, consultar status de solicitações e visualizar histórico de transações.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Desenvolvido por João Arthur Britto")
                                .url("https://joaoarthur.com")
                                .email("joaoabritto.dev@gmail.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));

    }
}
