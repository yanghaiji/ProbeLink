package com.javayh.probe.link.registration.metadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p>
 * 微服务的基本信息
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerBaseInfo {

    /**
     * 服务名
     */
    private String appName;

    /**
     * context path
     */
    private String contextPath;

    /**
     * 所有的url信息
     */
    private List<ProbeLink> probeLinks;
}
