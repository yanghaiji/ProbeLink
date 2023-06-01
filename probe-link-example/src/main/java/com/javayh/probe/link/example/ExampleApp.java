package com.javayh.probe.link.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
@EntityScan(basePackages = "com.javayh.probe.link.registration.metadata")
@SpringBootApplication
@ComponentScan("com.javayh.probe.link") // 1. 多模块项目需要扫描的包
@EnableJpaRepositories("com.javayh.probe.link.driver.repository.jdbc") // 2. Dao 层所在的包
@EnableJpaAuditing
public class ExampleApp {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }
}
