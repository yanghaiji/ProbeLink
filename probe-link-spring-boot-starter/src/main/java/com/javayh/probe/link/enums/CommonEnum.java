package com.javayh.probe.link.enums;

/**
 * <p>
 * 公用
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-06-05
 */
public enum CommonEnum {

    KEY(":", 0),
    ;


    private String keyName;
    private Integer status;

    CommonEnum(String keyName, Integer status) {
        this.keyName = keyName;
        this.status = status;
    }


    public String getKeyName() {
        return keyName;
    }

    public int getStatus() {
        return status;
    }
}
