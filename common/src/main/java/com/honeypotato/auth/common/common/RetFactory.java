package com.honeypotato.auth.common.common;

import com.honeypotato.auth.common.model.CommonRetStat;
import com.honeypotato.auth.common.model.IRetStat;
import com.honeypotato.auth.common.model.RetResult;

/**
 * web返回结果数据工厂类
 * @author sanyihwang on 2018/9/20.
 **/
public class RetFactory {
    /**
     * 构建接口成功返回数据
     * @param data 业务数据
     * @return 返回值
     */
    public static <T> RetResult success(T data) {
        return RetFactory.createResult(CommonRetStat.SUCCESS, data);
    }

    /**
     * 构建接口程序异常返回数据
     * @param data 业务数据
     * @return 返回值
     */
    public static RetResult error(Object data) {
        return RetFactory.createResult(CommonRetStat.ERROR, data);
    }

    /**
     * 构建接口返回数据
     * @param result 返回码
     * @param data 业务数据
     * @return 返回值
     */
    public static <T> RetResult createResult(IRetStat result, T data) {
        return new RetResult<>(result.getCode(), result.getMsg(), data);
    }

    /**
     * 构建接口返回数据
     * @param result 返回码
     * @return 返回值
     */
    public static RetResult createResult(IRetStat result) {
        return createResult(result, null);
    }
}
