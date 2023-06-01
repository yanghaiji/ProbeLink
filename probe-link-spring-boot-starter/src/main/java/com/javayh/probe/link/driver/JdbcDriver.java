package com.javayh.probe.link.driver;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.driver.repository.jdbc.ProbeLinkRepository;
import com.javayh.probe.link.driver.repository.jdbc.ServerBaseInfoRepository;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import com.javayh.probe.link.registration.metadata.ServerBaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
@Configuration
public class JdbcDriver {

    @Autowired
    private ServerBaseInfoRepository serverBaseInfoRepository;

    @Autowired
    private ProbeLinkRepository probeLinkRepository;


    public void initData(String appName, ServerBaseInfo baseInfo, ProbeLinkProperties probeLinkProperties) {
        // 查询
        ServerBaseInfo serverBaseInfo = serverBaseInfoRepository.getByAppName(appName);
        List<ProbeLink> newProbeLinks = baseInfo.getProbeLinks();
        // 不存在我们则新增
        if (Objects.isNull(serverBaseInfo)) {
            serverBaseInfoRepository.save(baseInfo);
        } else {
            // 存在则进行修改
            List<ProbeLink> oldProbeLinks = probeLinkRepository.getByProId(serverBaseInfo.getId());
            List<ProbeLink> probeLinks = new LinkedList<>();
            probeLinkRepository.saveAll(probeLinks);
        }

    }

}
