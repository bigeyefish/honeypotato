package com.honeypotato.common.model;

/**
 * 返回码和信息接口
 * @author sanyihwang
 */
public interface IRetStat {

    /**
     * 返回码
     * @return 返回码
     */
    int getCode();

    /**
     * 返回信息
     * @return 返回信息
     */
    String getMsg();
}
