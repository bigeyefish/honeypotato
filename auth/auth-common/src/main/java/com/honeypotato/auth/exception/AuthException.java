package com.honeypotato.auth.exception;


import com.honeypotato.common.exception.BaseServiceException;
import com.honeypotato.common.model.IRetStat;

/**
 * token过期异常
 * @author sanyihwang
 */
public class AuthException extends BaseServiceException {
    public AuthException(String message, IRetStat iRetStat) {
        super(message, iRetStat);
    }
}
