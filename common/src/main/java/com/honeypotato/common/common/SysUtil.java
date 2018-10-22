package com.honeypotato.common.common;

import javax.servlet.http.HttpServletRequest;

/**
 * 工具类
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
public class SysUtil {

    /**
     * 获取请求IP地址
     * @param request http请求
     * @return 真实IP地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
