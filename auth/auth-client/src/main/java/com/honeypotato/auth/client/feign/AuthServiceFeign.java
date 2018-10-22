package com.honeypotato.auth.client.feign;

import com.honeypotato.common.model.RetResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 权限服务feign
 *
 * @author sanyihwang.
 * created on 2018/9/30
 **/
@FeignClient(value = "${auth.serviceId:auth-server}")
public interface AuthServiceFeign {

    /**
     * 获取当前服务授权的客户端列表
     * @param serviceId 服务id
     * @param secret 密钥
     * @return 客户端列表
     */
    @GetMapping("/client/myClients")
    RetResult<List<String>> getMyClients(@RequestParam("serviceId") String serviceId, @RequestParam("secret") String secret);

    /**
     * 获取当前服务的token
     * @param clientId 服务id
     * @param secret 密钥
     * @return token
     */
    @PostMapping("/client/clientToken")
    RetResult<String> getClientToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

    /**
     * 获取服务的公钥
     * @param clientId 服务id
     * @param secret 密钥
     * @return 公钥
     */
    @PostMapping("/client/servicePubKey")
    RetResult<byte[]> getServicePubKey(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);
}
