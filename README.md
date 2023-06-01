# ProbeLink

> ProbeLink is a SpringBootStarter project custom-developed by Spring. It is used to scan all urls of the project after starting the project, so as to facilitate the statistics of the number and addresses of urls of all services, and to facilitate the unified management of interface permissions. It supports persistence to memory and database.
>

## Configuration introduction

ProbeLink will scan the interface of the service after the project is started. The project configuration is as follows:

```yaml
probe:
  link:
    enabled: true
    app-name: ${spring.application.name}
    base-uri: ${server.servlet.context-path}
    exclude:
      - org.springframework.boot.autoconfigure.web.servlet.error.TestController
    driver-type: memory
```

If you have not configured `app-name`, the name configured by `spring.application.name` will be selected as `app-name` by default, and `base-uri` will be selected as `server.servlet.context-path` if you have not configured default allocation
`exclude` is for the convenience of excluding the specified class from scanning, but this is not the real meaning of not scanning, but marking processing, 0: normal need to scan, 1: exclude url, but for the convenience of statistics and authority unification configuration, with different status flags

After the scan is complete, the console output is as follows:

```less
===================================
==== app server name : example-app
==== app context path : /sys/api
==== total number of urls : 5
===================================
```