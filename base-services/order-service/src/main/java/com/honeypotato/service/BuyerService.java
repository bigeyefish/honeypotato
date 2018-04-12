package com.honeypotato.service;

import com.honeypotato.common.bean.order.Buyer;
import com.honeypotato.common.iservice.order.IBuyerService;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public class BuyerService implements IBuyerService {

    @Override
    public Buyer findById(Object id) {
        return null;
    }

    @Override
    public Page<Buyer> findByPage(Pageable pageable) {
        return null;
    }

    @Override
    public List<Buyer> findByTbIdOrNickName(String key) {
        return null;
    }

    @Override
    public boolean insertOrUpdate(Buyer buyer) {
        return false;
    }
}
