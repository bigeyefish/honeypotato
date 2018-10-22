package com.honeypotato.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.Data;

import java.io.Serializable;

/**
 * jwt 承载数据
 * @author Lenovo on 2018/7/2.
 */
@Data
public class JwtPayload implements Serializable {

    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_NICK_NAME = "nickName";

    private String userName;
    private String userId;
    private String nickName;

    public JwtPayload(String userName, String userId, String nickName) {
        this.userName = userName;
        this.userId = userId;
        this.nickName = nickName;
    }

    public JwtPayload(Jws<Claims> jws) {
        Claims body = jws.getBody();
        this.userId = body.getSubject();
        this.userName = (String)body.get(KEY_USER_NAME);
        this.nickName = (String) body.get(KEY_NICK_NAME);
    }
}
