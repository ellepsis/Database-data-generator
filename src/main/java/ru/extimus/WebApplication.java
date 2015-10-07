package ru.extimus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vladislav on 30.09.15.
 */
@SpringBootApplication
public class WebApplication {
    public static void main(String... args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
