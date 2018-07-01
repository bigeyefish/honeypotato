package com.honeypotato.security.auth.common.util;

/**
 * Created by Lenovo on 2018/7/2.
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
