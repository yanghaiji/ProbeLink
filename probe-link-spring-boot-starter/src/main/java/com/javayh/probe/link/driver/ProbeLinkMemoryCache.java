package com.javayh.probe.link.driver;

import com.google.common.cache.Cache;
import com.javayh.probe.link.registration.metadata.ServerBaseInfo;
import com.javayh.probe.link.util.CacheUtils;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * 内存的数据驱动
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
@Slf4j
public class ProbeLinkMemoryCache {

    private final static Cache<String, ServerBaseInfo> CACHE = CacheUtils.buildCache();

    /**
     * 初始化缓存
     *
     * @param appName  key name
     * @param baseInfo 详细信息
     */
    public static void initCache(String appName, ServerBaseInfo baseInfo) {
        CACHE.put(appName, baseInfo);
    }

    /**
     * 获取缓存
     *
     * @param appName key name
     * @return {@link ServerBaseInfo }
     */
    public static ServerBaseInfo get(String appName) {
        return CACHE.getIfPresent(appName);
    }

    /**
     * 删除
     *
     * @param appName key name
     */
    public static void invalidate(String appName) {
        CACHE.invalidate(appName);
    }


}
