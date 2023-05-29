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

    private String method;

    private String className;

    private String type;

    private String url;

}
