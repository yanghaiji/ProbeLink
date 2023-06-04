package com.javayh.probe.link.driver;

import com.javayh.probe.link.registration.metadata.ProbeLink;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
@Slf4j
public class RabbitMqDriver {

    public static void initData(String appName, List<ProbeLink> baseInfo) {
        log.info("rabbitmq 持久化在未实现");
    }

}
