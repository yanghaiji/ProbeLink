package com.javayh.probe.link.registration.metadata;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.driver.JdbcDriver;
import com.javayh.probe.link.driver.KafkaDriver;
import com.javayh.probe.link.driver.ProbeLinkMemoryCache;
import com.javayh.probe.link.driver.RabbitMqDriver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * <p>
 * 数据聚合工具
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
@Slf4j
@Configuration
public class DataBuild {

    @Autowired
    private JdbcDriver jdbcDriver;

    /**
     * 数据构建与持久话
     *
     * @param appName             服务ming
     * @param url                 context path
     * @param probeLinks          存放所有的url信息{@link ProbeLink}
     * @param probeLinkProperties probe link的配置信息 {@link ProbeLinkProperties}
     */
    public void build(String appName, String url, List<ProbeLink> probeLinks, ProbeLinkProperties probeLinkProperties) {
        // 根据选择的驱动类型，进行不同方式的持久化
        switch (probeLinkProperties.getDriverType()) {
            case JDBC:
                jdbcDriver.initData(appName, probeLinks, probeLinkProperties);
                break;
            case KAFKA:
                KafkaDriver.initData(appName, probeLinks);
                break;
            case RABBITMQ:
                RabbitMqDriver.initData(appName, probeLinks);
                break;
            default:
                log.info("probe link memory persistence is used by default");
                ProbeLinkMemoryCache.initCache(appName, probeLinks);
        }
    }
}
