package com.javayh.probe.link.driver;

import com.google.common.cache.Cache;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import com.javayh.probe.link.util.CacheUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


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

    private final static Cache<String, List<ProbeLink>> CACHE = CacheUtils.buildCache();

    /**
     * 初始化缓存
     *  @param appName  key name
     * @param baseInfo 详细信息
     */
    public static void initCache(String appName, List<ProbeLink> baseInfo) {
        CACHE.put(appName, baseInfo);
    }

    /**
     * 获取缓存
     *
     * @param appName key name
     * @return {@link ProbeLink }
     */
    public static List<ProbeLink> get(String appName) {
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
