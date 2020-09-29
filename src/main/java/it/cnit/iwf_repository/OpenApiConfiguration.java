package it.cnit.iwf_repository;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    final BuildProperties buildProperties;

    public OpenApiConfiguration(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
            .title("IWF Repository API")
            .description("REST API module to manage 5G EVE site information (formerly site-inventory)")
            .version(buildProperties.getVersion())
            .license(new io.swagger.v3.oas.models.info.License().name("Apache 2.0"))
            .contact(new Contact()
                .name("GitHub")
                .url("https://github.com/5GEVE/iwf-repository")));
    }

}
