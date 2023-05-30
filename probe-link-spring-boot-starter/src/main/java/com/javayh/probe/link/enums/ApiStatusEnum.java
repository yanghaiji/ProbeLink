package com.javayh.probe.link.enums;

/**
 * <p>
 * api状态
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
public enum ApiStatusEnum {
    INCLUDE("include", 0),
    EXCLUDE("exclude", 1),

    ;

    ApiStatusEnum(String keyName, int status) {
        this.keyName = keyName;
        this.status = status;
    }

    private String keyName;
    private int status;

    public String getKeyName() {
        return keyName;
    }

    public int getStatus() {
        return status;
    }
}
