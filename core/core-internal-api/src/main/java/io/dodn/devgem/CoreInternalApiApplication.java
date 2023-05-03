package io.dodn.devgem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class CoreInternalApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreInternalApiApplication.class, args);
    }
}
