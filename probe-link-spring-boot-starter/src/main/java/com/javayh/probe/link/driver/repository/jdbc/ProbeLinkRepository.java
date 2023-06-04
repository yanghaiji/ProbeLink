package com.javayh.probe.link.driver.repository.jdbc;

import com.javayh.probe.link.registration.metadata.ProbeLink;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface ProbeLinkRepository extends CrudRepository<ProbeLink, String> {

    List<ProbeLink> getByAppName(String appName);
}
