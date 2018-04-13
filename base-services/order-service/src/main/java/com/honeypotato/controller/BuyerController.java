package com.honeypotato.controller;

import com.honeypotato.common.dto.order.Buyer;
import com.honeypotato.common.iservice.order.IBuyerService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by Lenovo on 2018/4/13.
 */
@RestController
public class BuyerController implements IBuyerService {

    @Override
    public Buyer findById(Object id) {
        return null;
    }

    @Override
    public Page<Buyer> findByPage(Pageable pageable) {
        return null;
    }

    @Override
    public List<Buyer> findByTbIdOrNickName(@PathVariable("key") String key) {
        System.out.println(key + "===================");
        return null;
    }

    @Override
    public boolean insertOrUpdate(Buyer buyer) {
        return false;
    }
}
