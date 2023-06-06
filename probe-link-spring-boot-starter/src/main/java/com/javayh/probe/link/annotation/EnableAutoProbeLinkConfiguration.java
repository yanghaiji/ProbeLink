package com.javayh.probe.link.annotation;

import com.javayh.probe.link.enums.ComponentScanEnum;
import com.javayh.probe.link.fiter.ProbeLinkSelector;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.lang.annotation.*;

/**
 * <p>
 * 自定注入
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ProbeLinkSelector.class)
@Configuration
@EnableJpaAuditing
@ComponentScan(ComponentScanEnum.COMPONENT_SCAN_ENUM_SCAN)
@EnableJpaRepositories(ComponentScanEnum.REPOSITORIES)
@EntityScan(basePackages = ComponentScanEnum.ENTITY_SCAN)
public @interface EnableAutoProbeLinkConfiguration {
}
