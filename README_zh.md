# ProbeLink

##### [ProbeLink 中文文档](README_zh.md)

> ProbeLink 是利用Spring自定义开发的SpringBootStarter项目，用于在启动项目后扫描项目所有的url，以方便统计所有服务的url数量与地址，以方便进行接口的权限统一管理
> 支持持久化到memory与数据库中
>

## 配置介绍

ProbeLink 会在项目启动完成后进行服务的接口扫描，项目配置如下：

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

如果您没有配置`app-name`则默认选取`spring.application.name`配置的名字作为`app-name`,`base-uri`如果您没有配置则选择`server.servlet.context-path`作为默认配置
`exclude`为了方便排除指定的类不进行扫描，但这里并不是真正意义上的不扫描，而是进行标记处理， 0:正常需要扫描的， 1:exclude的url，但是为了方便统计和权限统一配置，进行了不同的状态标记

扫描完成后会在控制台输出如下:

```less
===================================
==== app server name : example-app
==== app context path : /sys/api
==== total number of urls : 5
===================================
```