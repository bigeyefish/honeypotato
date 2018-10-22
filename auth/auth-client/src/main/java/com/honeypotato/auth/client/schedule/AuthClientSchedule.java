package com.honeypotato.auth.client.schedule;

/**
 * 定时更新公钥
 *
 * @author sanyihwang.
 * created on 2018/10/9
 **/

import com.honeypotato.auth.client.feign.AuthServiceFeign;
import com.honeypotato.auth.client.model.AuthProperties;
import com.honeypotato.common.model.RetResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AuthClientSchedule {

    @Autowired
    private AuthProperties authProperties;

    @Autowired
    private AuthServiceFeign authServiceFeign;

    @Scheduled(fixedDelay = 1000 * 60)
    public void refreshUserPubKey() {
        System.out.println("刷新用户公钥数据---");
        // System.out.println(authProperties);
        RetResult<String> result = authServiceFeign.getClientToken(authProperties.getClientId(), authProperties.getSecret());
        System.out.println(result);
    }

    public void refreshServicePubKey() {
        // authServiceFeign.getServicePubKey(authProperties.getClientId(), authProperties.getSecret());
    }
}
