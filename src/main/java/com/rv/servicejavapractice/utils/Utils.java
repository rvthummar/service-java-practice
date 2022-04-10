package com.rv.servicejavapractice.utils;

import java.util.Collection;

public class Utils {
    public static Boolean isObjectNullOrEmpty(Object value) {
        return (value == null
                || (value instanceof String ? (((String) value).isEmpty()
                || "".equals(((String) value).trim())
                || "null".equals(value)
                || "undefined".equals(value)) : false));
    }

    public static Boolean isObjectNullOrEmptyOrDash(Object value) {
        return (value == null
                || (value instanceof String ? (((String) value).isEmpty()
                || "".equals(((String) value).trim())
                || "null".equals(value)
                || "undefined".equals(value)
                || "-".equals(value)) : false));
    }

    public static Boolean isListNullOrEmpty(Collection<?> data) {
        return (data == null || data.isEmpty());
    }
}
