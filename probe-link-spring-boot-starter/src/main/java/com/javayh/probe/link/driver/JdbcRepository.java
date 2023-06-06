package com.javayh.probe.link.driver;

import com.javayh.probe.link.driver.repository.jdbc.ProbeLinkRepository;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
public class JdbcRepository {

    private final ProbeLinkRepository probeLinkRepository;

    public JdbcRepository(ProbeLinkRepository probeLinkRepository) {
        this.probeLinkRepository = probeLinkRepository;
    }

    /**
     * 数据
     *
     * @param appName  appName
     * @param baseInfo {@link ProbeLink} 的集合
     */
    public void initData(String appName, List<ProbeLink> baseInfo) {
        // 查询
        List<ProbeLink> serverBaseInfo = probeLinkRepository.getByAppName(appName);
        // 不存在我们则新增
        if (CollectionUtils.isEmpty(serverBaseInfo)) {
            probeLinkRepository.saveAll(baseInfo);
        } else if (serverBaseInfo.size() != baseInfo.size()) {
            // 存在则进行修改
            List<ProbeLink> probeLinks = new LinkedList<>();
            // 数据准备
            Map<String, ProbeLink> probeLinkMap = probeLinkMap(serverBaseInfo);
            Map<String, ProbeLink> baseInfoMap = probeLinkMap(baseInfo);
            // 数据对比
            baseInfoMap.forEach((key, vale) -> {
                if (!probeLinkMap.containsKey(key)) {
                    probeLinks.add(baseInfoMap.get(key));
                }
            });
            if (!CollectionUtils.isEmpty(probeLinks)) {
                // 新增数据
                probeLinkRepository.saveAll(probeLinks);
            }
        }

    }

    /**
     * 生成资源
     *
     * @param probeLinks {@link ProbeLink}
     */
    private Map<String, ProbeLink> probeLinkMap(List<ProbeLink> probeLinks) {
        return probeLinks.stream().collect(Collectors.toMap(ProbeLink::getKey, probeLink -> probeLink));
    }


}
