package com.javayh.probe.link.configuration;

import lombok.Data;
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
@Data
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
    @Deprecated
    private List<String> include;

    /**
     * 排除扫描的包
     *
     * <p>
     * 例如: {@link org.springframework.boot.context.properties.ConfigurationProperties}
     * 暂时不支持指定整个包的逻辑
     * </p>
     *
     * @version 1.0.0
     */
    private List<String> exclude;

    /***
     * 是否开启，默认开启
     */
    private boolean enabled = true;

    public void setExclude(List<String> exclude) {
        exclude.add("org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController");
        this.exclude = exclude;
    }
}
