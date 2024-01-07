package br.com.leads.ms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String LEAD_CONTROLLER_TAG = "Lead Controller Api";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(("br.com.leads.ms.controller")))
                .paths(PathSelectors.ant("/v1/leads/**"))
                .build().tags(new Tag(LEAD_CONTROLLER_TAG, "API for the leads management"));
    }
}
