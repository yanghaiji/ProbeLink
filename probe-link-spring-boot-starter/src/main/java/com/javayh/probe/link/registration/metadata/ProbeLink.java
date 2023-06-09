package com.javayh.probe.link.registration.metadata;

import com.javayh.probe.link.enums.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

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
@Entity
@Table(name = "probe_link_tcu_info")
@EntityListeners(value = AuditingEntityListener.class)
public class ProbeLink {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * 服务名
     */
    private String appName;

    /**
     * context path
     */
    private String contextPath;

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

    /**
     * 创建时间
     */
    @CreatedDate
    private Date createTime;

    /**
     * 修改时间
     */
    @LastModifiedDate
    private Date updateTime;

    public String getType() {
        return Objects.isNull(type) ? "" : type;
    }

    /**
     * 拼接key
     */
    public String getKey() {
        StringBuilder sb = new StringBuilder();
        String keyName = CommonEnum.KEY.getKeyName();
        sb.append(appName).append(keyName)
                .append(method).append(keyName)
                .append(className).append(keyName)
                .append(getType()).append(keyName).append(url);
        return sb.toString();
    }
}
