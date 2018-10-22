package com.honeypotato.auth.client.configuration;

import com.honeypotato.auth.client.model.AuthProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 缺省配置类
 *
 * @author sanyihwang.
 * created on 2018/10/8
 **/
@Configuration
@ConditionalOnProperty(name = {"auth.enable"}, matchIfMissing = true)
@EnableConfigurationProperties(AuthProperties.class)
@EnableScheduling
@ComponentScan({"com.honeypotato.auth.client"})
@EnableFeignClients({"com.honeypotato.auth.client.feign"})
public class DefaultConfiguration {

}
