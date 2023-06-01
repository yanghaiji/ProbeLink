package com.javayh.probe.link.driver.repository.jdbc;

import com.javayh.probe.link.registration.metadata.ServerBaseInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-06-01
 */
@Configuration
@Repository
public interface ServerBaseInfoRepository extends JpaRepository<ServerBaseInfo, Long> {

    ServerBaseInfo getByAppName(String appName);

}
