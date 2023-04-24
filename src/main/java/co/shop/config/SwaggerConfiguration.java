package co.shop.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        List<String> contentTypes = new ArrayList<>();
        contentTypes.add("application/json");
        contentTypes.add("application/x-www-form-urlencoded");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
//                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(metadata())
                .useDefaultResponseMessages(false)
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("JWT", "Authorization", "header"))))
                .genericModelSubstitutes(Optional.class)
                .globalOperationParameters(Arrays.asList(new ParameterBuilder()
                        .name("Content-Type").required(true)
                        .description("content-type")
                        .modelRef(new ModelRef("String"))
                        .parameterType("header")
                        .allowableValues(new AllowableListValues(contentTypes, "String"))
                        .required(true)
                        .build()))
                .globalOperationParameters(Arrays.asList(new ParameterBuilder()
                        .name("Channel").required(true)
                        .description("channel-key")
                        .modelRef(new ModelRef("string"))
                        .parameterType("header")
                        .required(true)
                        .build()));

    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Godar API reference for developers")
                .description(
                        " Godar is a framework designed on the basis of the latest technologies to produce Java programming language." +
                                " The framework is designed and implemented using a micro service that enables scalability at any three levels." +
                                " In its implementation, it utilizes both Spring Cloud and React.js technology." +
                                " The database also uses the high-performance PostgreSQL, MongoDB and Redis hashes, and is capable of responding to concurrent" +
                                " transactions due to its robust exploitation of load balancing technologies.")
                .version("2.0.0")
                .license("HayTech License").licenseUrl("http://haytech.ir")
                .contact(new Contact("HayTech", "http://haytech.ir", "develop@haytech.ir"))
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
    }

}
