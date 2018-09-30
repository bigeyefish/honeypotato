package com.honeypotato.auth.common.util;

/**
 * 字符串工具类
 *
 * @author sanyihwang.
 * created on 2018/9/30
 **/
public class MyStrUtil {

    /**
     * 获取对象字符（不存在返回空字符串）
     * @param obj
     * @return
     */
    public static String getObjectVal(Object obj){
        return obj == null ? "" : obj.toString();
    }
}
