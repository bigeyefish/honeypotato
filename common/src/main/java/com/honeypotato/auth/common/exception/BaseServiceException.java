package com.honeypotato.auth.common.exception;

import com.honeypotato.auth.common.model.IRetStat;

/**
 * 基础异常类
 * @author sanyihwang
 */
public class BaseServiceException extends RuntimeException {

    private IRetStat retStat;

    public BaseServiceException() {
        super();
    }

    public BaseServiceException(String message, IRetStat retStat) {
        super(message);
        this.retStat = retStat;
    }

    public BaseServiceException(IRetStat retStat) {
        super();
        this.retStat = retStat;
    }

}
