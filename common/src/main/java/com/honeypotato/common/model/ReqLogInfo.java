package com.honeypotato.common.model;

import lombok.Data;

/**
 * 请求日志实体
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
@Data
public class ReqLogInfo {

    private String module;

    private String content;

    private String type;

    private String errClass;

    private String errMessage;

    private String method;

    private String userId;

    private String ip;

    private String url;

    private String sessionId;

    private String reqMethod;

    private String params;

    private Long reqTime;

    private Long costTime;

    private String result;

    @Override
    public String toString() {
        if (null != errClass) {
            return "ReqLogInfo{" +
                    "module='" + module + '\'' +
                    ", type='" + type + '\'' +
                    ", errClass='" + errClass + '\'' +
                    ", errMessage='" + errMessage + '\'' +
                    ", method='" + method + '\'' +
                    ", userId='" + userId + '\'' +
                    ", ip='" + ip + '\'' +
                    ", url='" + url + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", reqMethod='" + reqMethod + '\'' +
                    ", params='" + params + '\'' +
                    ", reqTime=" + reqTime +
                    ", costTime=" + costTime +
                    '}';
        } else {
            return "ReqLogInfo{" +
                    "module='" + module + '\'' +
                    ", type='" + type + '\'' +
                    ", method='" + method + '\'' +
                    ", userId='" + userId + '\'' +
                    ", ip='" + ip + '\'' +
                    ", url='" + url + '\'' +
                    ", sessionId='" + sessionId + '\'' +
                    ", reqMethod='" + reqMethod + '\'' +
                    ", params='" + params + '\'' +
                    ", reqTime=" + reqTime +
                    ", costTime=" + costTime +
                    ", result='" + result + '\'' +
                    '}';
        }
    }
}
