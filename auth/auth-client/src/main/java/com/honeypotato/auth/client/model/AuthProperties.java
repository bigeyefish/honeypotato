package com.honeypotato.auth.client.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 权限相关配置
 *
 * @author sanyihwang.
 * created on 2018/10/8
 **/
@Data
@ConfigurationProperties
public class AuthProperties {

    @Value("${auth.enable:true}")
    private boolean enable;

    @Value("${auth.user.token-header:Authorization}")
    private String userTokenHeader;

    @Value("${auth.client.token-header:x-client-token}")
    private String clientTokenHeader;

    @Value("${auth.client.id:${spring.application.name}}")
    private String clientId;

    @Value("${auth.client.secret}")
    private String secret;

}
