package com.honeypotato.service;

import com.honeypotato.userservice.iservice.order.IBuyerService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by Lenovo on 2018/4/13.
 */
@FeignClient(value = "order-service")
public interface BuyerService extends IBuyerService {
}
