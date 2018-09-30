package com.honeypotato.auth.common.exception;


import com.honeypotato.auth.common.model.IRetStat;

/**
 * token过期异常
 * @author sanyihwang
 */
public class AuthException extends BaseServiceException {
    public AuthException(String message, IRetStat iRetStat) {
        super(message, iRetStat);
    }
}
