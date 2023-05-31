package com.javayh.probe.link.util;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.enums.AppInfoEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;

/**
 * <p>
 * properties 预处理
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
public class PropertiesCover {

    /**
     * 获取服务名
     *
     * @param appName {@link ProbeLinkProperties#getAppName()}
     * @return 首先获取 {@link ProbeLinkProperties#getAppName()} 如果为空，则获取{@link Environment#getProperty(String)}的值作为默认值
     */
    public static String getAppName(String appName, Environment environment) {
        return StringUtils.isEmpty(appName) ? environment.getProperty(AppInfoEnum.APP_NAME.getKeyName()) : appName;
    }

    /**
     * 获取url
     *
     * @param url {@link ProbeLinkProperties#getBaseUri()}
     * @return 首先获取 {@link ProbeLinkProperties#getBaseUri()} 如果为空，则获取{@link Environment#getProperty(String)}的值作为默认值
     */
    public static String getUrl(String url, Environment environment) {
        return StringUtils.isEmpty(url) ? environment.getProperty(AppInfoEnum.APP_CONTEXT_PATH.getKeyName()) : url;
    }
}
