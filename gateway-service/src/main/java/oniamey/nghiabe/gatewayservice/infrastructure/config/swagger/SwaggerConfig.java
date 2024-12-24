package oniamey.nghiabe.gatewayservice.infrastructure.config.swagger;

import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class SwaggerConfig {

    @Bean
    @Primary
    @Qualifier("customSwaggerUiConfig")
    public SwaggerUiConfigPropertiesV1 swaggerUiConfigProperties() {
        return new SwaggerUiConfigPropertiesV1();
    }

    @Bean
    public SwaggerUiConfigParameters swaggerUiConfigParameters(SwaggerUiConfigPropertiesV1 swaggerUiConfigProperties) {
        return new SwaggerUiConfigParameters(swaggerUiConfigProperties);
    }
}
