package com.honeypotato.auth.common.model;

/**
 * 错误码枚举类
 * Created by sanyihwang on 2018/9/20.
 **/
public enum CommonRetStat implements IRetStat {

    /* 成功 */
    SUCCESS(0, "success"),
    /* 失败 */
    ERROR(-1, "system error");

    private int code;
    private String msg;

    CommonRetStat(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
