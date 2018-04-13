package com.honeypotato.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Lenovo on 2018/4/13.
 */
@Service
public class TaoBaoOrderService {

    @Autowired
    private BuyerService buyerService;

    public void addOrderList() {
        buyerService.findByTbIdOrNickName("huitailang");
    }
}
