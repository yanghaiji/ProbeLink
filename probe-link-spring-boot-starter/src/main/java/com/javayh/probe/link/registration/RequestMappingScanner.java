package com.javayh.probe.link.registration;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.enums.ApiStatusEnum;
import com.javayh.probe.link.registration.metadata.ProbeLink;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PathPatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-29
 */
public class RequestMappingScanner {

    private WebApplicationContext applicationContext;

    public RequestMappingScanner(WebApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * <p>
     * 扫描mapping
     * </p>
     *
     * @param probeLinkProperties {@link ProbeLinkProperties}
     * @param appName
     * @param url
     * @return java.util.List<com.javayh.probe.link.registration.metadata.ProbeLink>
     * @version 1.0.0
     * @author hai ji
     * @since 2023/5/29
     */
    public List<ProbeLink> scanner(ProbeLinkProperties probeLinkProperties, String appName, String contextPath) {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();
        List<String> exclude = probeLinkProperties.getExclude();
        List<ProbeLink> probeLinks = new LinkedList<>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            PathPatternsRequestCondition p = info.getPathPatternsCondition();
            assert p != null;
            Method methodMethod = method.getMethod();
            String typeName = method.getBeanType().getTypeName();
            ProbeLink.ProbeLinkBuilder probeLink = ProbeLink.builder()
                    .className(methodMethod.getDeclaringClass().getName())
                    .contextPath(contextPath).appName(appName)
                    .method(methodMethod.getName());
            // 进行状态标记
            if (exclude.contains(typeName)) {
                probeLink.status(ApiStatusEnum.EXCLUDE.getStatus());
            } else {
                probeLink.status(ApiStatusEnum.INCLUDE.getStatus());
            }
            for (String url : p.getDirectPaths()) {
                probeLink.url(url);
            }
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            for (RequestMethod requestMethod : methodsCondition.getMethods()) {
                probeLink.type(requestMethod.toString());
            }
            probeLinks.add(probeLink.build());
        }
        return probeLinks;
    }
}
