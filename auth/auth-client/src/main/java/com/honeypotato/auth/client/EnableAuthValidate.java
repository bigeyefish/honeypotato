package com.honeypotato.auth.client;

import com.honeypotato.auth.client.configuration.DefaultConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 是否开启权限校验
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DefaultConfiguration.class)
@Deprecated
public @interface EnableAuthValidate {

}
