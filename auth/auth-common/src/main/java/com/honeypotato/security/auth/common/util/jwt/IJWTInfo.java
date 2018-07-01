package com.honeypotato.security.auth.common.util.jwt;

/**
 * Created by Lenovo on 2018/7/2.
 */
public interface IJWTInfo {

    /**
     * 获取用户名
     * @return
     */
    String getUnitqueName();

    /**
     * 获取用户id
     * @return
     */
    String getId();

    /**
     * 获取名称
     * @return
     */
    String getName();
}
