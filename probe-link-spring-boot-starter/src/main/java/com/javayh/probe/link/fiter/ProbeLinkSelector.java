package com.javayh.probe.link.fiter;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>
 * 选择器
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
public class ProbeLinkSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                "com.javayh.probe.link.registration.RequestMappingScanner",
                "com.javayh.probe.link.registration.ProbeLinkCommandLineRunner",
                "com.javayh.probe.link.configuration.ProbeLinkProperties",
                "com.javayh.probe.link.driver.JdbcDriver",
                "com.javayh.probe.link.driver.repository.jdbc.ProbeLinkRepository",
                "com.javayh.probe.link.driver.repository.jdbc.ServerBaseInfoRepository"
        };
    }
}
