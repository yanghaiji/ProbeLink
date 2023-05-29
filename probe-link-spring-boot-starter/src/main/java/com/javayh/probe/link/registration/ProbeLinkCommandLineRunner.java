package com.javayh.probe.link.registration;

import com.alibaba.fastjson.JSON;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

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

    public ProbeLinkCommandLineRunner(RequestMappingScanner requestMappingScanner) {
        this.requestMappingScanner = requestMappingScanner;
    }

    @Override
    public void run(String... args) throws Exception {
        List<ProbeLink> scanner = requestMappingScanner.scanner();
        log.info(JSON.toJSONString(scanner));
    }
}
