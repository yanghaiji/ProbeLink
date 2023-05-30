package com.javayh.probe.link.enums;

/**
 * <p>
 * application 的相关信息
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
public enum AppInfoEnum {

    APP_NAME("spring.application.name", 0),
    APP_CONTEXT_PATH("server.servlet.context-path", 1),
    ;


    private String keyName;
    private int index;

    public String getKeyName() {
        return keyName;
    }

    public int getIndex() {
        return index;
    }

    AppInfoEnum(String keyName, int index) {
        this.keyName = keyName;
        this.index = index;
    }
}
