package it.cnit.iwf_repository;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SpringFoxConfig {

  @Autowired
  BuildProperties buildProperties;

  @Bean
  public Docket api() {
    ApiInfo apiInfo = new ApiInfo(
        "IWF Repository API",
        "Simple REST API to manage 5G EVE site information (formerly site-inventory)",
        buildProperties.getVersion(),
        "",
        null,
        "Apache 2.0",
        "",
        Collections.emptyList()
    );
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .ignoredParameterTypes(org.springframework.hateoas.Link.class);
  }
}
