package com.javayh.probe.link.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * <p>
 * 扫描相关的配置
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
@ConfigurationProperties(prefix = "probe.link")
public class ProbeLinkProperties {
    /**
     * 当前的应用ming
     */
    private String appName;

    /**
     * base url
     */
    private String baseUri;
    ;


    /**
     * 指定扫描的包
     */
    private List<String> include;

    /**
     * 排除扫描的包
     */
    private List<String> exclude;

    /***
     * 是否开启，默认开启
     */
    private boolean enabled = true;
}
