package com.javayh.probe.link.util;

import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-30
 */
public class IdGenUtils {

    public static String idGen() {
        return UUID.randomUUID().toString();
    }

}

