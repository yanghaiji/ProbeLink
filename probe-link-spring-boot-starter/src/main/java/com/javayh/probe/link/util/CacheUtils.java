package com.javayh.probe.link.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 缓存
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
public class CacheUtils {

    /**
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Cache<K, V> buildCache() {
        return CacheBuilder.newBuilder()
                .initialCapacity(10)
                // 永不过期
                .expireAfterWrite(Long.MAX_VALUE, TimeUnit.SECONDS)
                // 最大的长度
                .maximumSize(10000)
                // 通过 asyncReloading 实现全异步加载，包括 refreshAfterWrite 被阻塞的加载线程
                .build();
//                .build(CacheLoader.asyncReloading(loader, Executors.newCachedThreadPool()));
    }
}
