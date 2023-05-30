package com.javayh.probe.link.annotation;

import com.javayh.probe.link.fiter.ProbeLinkSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
public @interface EnableAutoProbeLinkConfiguration {
}
