package com.honeypotato.auth.client.feign;

import com.honeypotato.auth.common.model.RetResult;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 权限服务feign
 *
 * @author sanyihwang.
 * created on 2018/9/30
 **/
@FeignClient(value = "${auth.serviceId}")
public interface AuthServiceFeign {
    // public RetResult
}
