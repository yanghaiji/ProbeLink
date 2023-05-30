package com.javayh.probe.link.registration;

import com.alibaba.fastjson.JSON;
import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import com.javayh.probe.link.utils.PropertiesCover;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
@Slf4j
public class ProbeLinkCommandLineRunner implements CommandLineRunner {

    private final RequestMappingScanner requestMappingScanner;
    private final Environment environment;
    private final ProbeLinkProperties probeLinkProperties;


    public ProbeLinkCommandLineRunner(RequestMappingScanner requestMappingScanner, Environment environment,
                                      ProbeLinkProperties probeLinkProperties) {
        this.requestMappingScanner = requestMappingScanner;
        this.environment = environment;
        this.probeLinkProperties = probeLinkProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        String probeName = probeLinkProperties.getAppName();
        String probeUri = probeLinkProperties.getBaseUri();
        // current app name
        String appName = PropertiesCover.getAppName(probeName, environment);
        // current url
        String url = PropertiesCover.getUrl(probeUri, environment);
        List<ProbeLink> scanner = requestMappingScanner.scanner(probeLinkProperties);
        log.info(JSON.toJSONString(scanner));
    }

}
