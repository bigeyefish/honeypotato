package com.honeypotato.auth.common.common;

import com.honeypotato.auth.common.model.IRetStat;

/**
 * 权限错误字典
 *
 * @author sanyihwang.
 * created on 2018/9/30
 **/
public enum AuthResultEnum implements IRetStat {

    LOGIN_FAIL(1001, "用户名或密码错误"),
    HAVE_NOT_LOGIN(1002, "用户未登陆"),
    LEAK_PARAM(1003, "缺少参数"),
    PASSWD_INCORRECT(1004, "密码错误"),
    PASSWD_LENGTH_ERR(1005, "密码长度在6-16之间"),
    MD5_ERR(1006, "MD5加密异常"),
    FIRST_LOGIN(1007, "未登陆"),
    ILLEGAL_TOKEN(1008, "非法token"),
    TOKEN_TIMEOUT(1009, "token 过期"),
    GENERATE_KEY_ERROR(1010, "生成KEY异常"),
    USER_DONOT_EXIST(1011, "用户不存在"),
    USER_INACTIVE(1012, "用户不可用"),
    UNAUTHORIZED(1013, "无权访问资源");
    // ILLEGAL_CRON(1013, "cron表达式非法"),
    // DELETE_QUARTZ_JOB_ERROR(1014, "删除quartz中job失败"),
    // SCORE_NOT_ENOUGH(1015, "剩余分值不足"),
    // MISS_JOB_GRAB(1016, "任务已经被别人抢走，你手慢了");

    private int code;
    private String msg;

    AuthResultEnum(int code, String msg) {
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
