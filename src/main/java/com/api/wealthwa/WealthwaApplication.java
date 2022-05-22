package com.api.wealthwa;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Wealth API", version = "2.0", description = "Wealth Information"))
public class WealthwaApplication {
    public static void main(String[] args) {
        SpringApplication.run(WealthwaApplication.class, args);
    }

}
