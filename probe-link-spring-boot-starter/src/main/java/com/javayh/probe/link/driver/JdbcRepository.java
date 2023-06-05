package com.javayh.probe.link.driver;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.driver.repository.jdbc.ProbeLinkRepository;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
public class JdbcRepository {

    private final ProbeLinkRepository probeLinkRepository;

    public JdbcRepository(ProbeLinkRepository probeLinkRepository) {
        this.probeLinkRepository = probeLinkRepository;
    }


    public void initData(String appName, List<ProbeLink> baseInfo) {
        // 查询
        List<ProbeLink> serverBaseInfo = probeLinkRepository.getByAppName(appName);
        // 不存在我们则新增
        if (Objects.isNull(serverBaseInfo)) {
            probeLinkRepository.saveAll(baseInfo);
        } else {
            // 存在则进行修改
            List<ProbeLink> probeLinks = new LinkedList<>();
            // 数据对比
            baseInfo.forEach(o -> {
                serverBaseInfo.forEach(server -> {
                    if (!(server.getClassName().equals(o.getClassName()) && server.getUrl().equals(o.getUrl())
                            && server.getType().equals(o.getType()) && server.getMethod().equals(o.getMethod()))) {
                        probeLinks.add(o);
                    }
                });
            });
            // 新增数据
            probeLinkRepository.saveAll(probeLinks);
        }

    }

}
