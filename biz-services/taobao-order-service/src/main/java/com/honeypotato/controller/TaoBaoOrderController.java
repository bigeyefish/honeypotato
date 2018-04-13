package com.honeypotato.controller;

import com.honeypotato.service.TaoBaoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 2018/4/13.
 */
@RestController
@RequestMapping("taobaoOrder")
public class TaoBaoOrderController {

    @Autowired
    private TaoBaoOrderService taoBaoOrderService;

    @GetMapping
    public String test() {
        taoBaoOrderService.addOrderList();
        return "success";
    }
}
