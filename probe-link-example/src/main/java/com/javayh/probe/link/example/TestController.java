package com.javayh.probe.link.example;

import com.javayh.probe.link.driver.ProbeLinkMemoryCache;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-23
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "/user")
    public Map<String, String> user() {
        Map<String, String> user = new HashMap<>();
        user.put("username", "yanghaiji");
        user.put("password", "654321");
        return user;
    }

    @GetMapping(value = "/user/add")
    public Map<String, String> adduser(Map<String, String> user) {
        return user;
    }


    @GetMapping(value = "/get")
    public List<ProbeLink> get() {
        return ProbeLinkMemoryCache.get("example-app");
    }

    @GetMapping(value = "/get/user")
    public List<ProbeLink> getUset() {
        return ProbeLinkMemoryCache.get("example-app");
    }
}
