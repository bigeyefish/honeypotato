package com.honeypotato.auth.server.controller;

import com.honeypotato.common.aop.ReqLog;
import com.honeypotato.common.common.RetFactory;
import com.honeypotato.common.model.RetResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * 调用服务的客户端相关的Feign接口
 *
 * @author sanyihwang.
 * created on 2018/10/15
 **/
@RestController
@RequestMapping("client")
public class ClientController {

    @ReqLog
    @GetMapping("myClients")
    public RetResult getMyClients(String serviceId, String secret) {
        return RetFactory.success(Collections.singleton("getMyClients接口返回数据" + serviceId + "," + secret));
    }

    @ReqLog
    @PostMapping("clientToken")
    public RetResult getClientToken(String clientId, String secret) {
        return RetFactory.success("getClientToken接口返回数据" + clientId + "," + secret);
    }

    @ReqLog
    @PostMapping("servicePubKey")
    public RetResult getServicePubKey(String clientId, String secret) {
        return RetFactory.success("getServicePubKey接口返回数据" + clientId + "," + secret);
    }
}
