package com.javayh.probe.link.registration.metadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * url相关记录
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProbeLink {
    /**
     * 方法
     */
    private String method;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法类型
     */
    private String type;

    /**
     * url
     */
    private String url;

    /**
     * 状态， 0:正常需要扫描的， 1:排除掉的url，但是为了方便统计，这里也需要扫描出来，以方便后期的修改
     */
    private Integer status;

}
