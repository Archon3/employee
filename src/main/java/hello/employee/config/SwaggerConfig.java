package hello.employee.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "TEST API",
                description = "API 명세서 입니다.",
                version = "v0.0.1"),
        servers = {@Server(url = "http://localhost:8080/", description ="localhost")}
)

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi corporationTaxOpenAPi() {

        String[] paths = {"/**"};

        return GroupedOpenApi
                .builder()
                .group("TEST API")
                .pathsToMatch(paths)
                .build();
    }
}