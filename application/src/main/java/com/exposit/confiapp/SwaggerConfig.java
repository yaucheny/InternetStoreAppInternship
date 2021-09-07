package com.exposit.confiapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * Class to configure swagger parameters.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * Configures swagger.
     *
     * @return Swagger configuration
     * @author Yauheni Markevich
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(basicAuthScheme()))
                .apiInfo(apiInfo());
    }

    /**
     * Configures information for swagger main page.
     *
     * @return Info of swagger html page.
     * @author Yauheni Markevich
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "My INTERNSHIP API",
                "Some custom description of API.",
                "API TOS",
                "Terms of service",
                new Contact("Markevich Yauheni", "www.example.com", "2879105@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    /**
     * Configures security context.
     *
     * @return Configuration pf sequrity context
     * @author Yauheni Markevich
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(basicAuthReference()))
                .build();
    }

    /**
     * Returns type of authentication.
     *
     * @return Schema of basic authentication.
     * @author Yauheni Markevich
     */
    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    /**
     * Returns type of security reference.
     *
     * @return Reference of basic authentication.
     * @author Yauheni Markevich
     */
    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

}

