package com.javayh.probe.link.registration.metadata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;
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
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "probe_link_app_base_info")
@EntityListeners(value = AuditingEntityListener.class)
public class ServerBaseInfo {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 服务名
     */
    @Column(columnDefinition = "VARCHAR(64) UNIQUE NOT NULL")
    private String appName;

    /**
     * context path
     */
    private String contextPath;

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

    /**
     * 所有的url信息
     */
    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "proId")
//    @JoinTable(name = "probe_link_tcu_info", joinColumns = {
//            @JoinColumn(name = "pro_id") }, inverseJoinColumns = { @JoinColumn(name = "id") })
    private List<ProbeLink> probeLinks;
}
