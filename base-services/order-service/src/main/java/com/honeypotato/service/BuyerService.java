package com.honeypotato.service;

import com.honeypotato.common.dto.order.Buyer;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public class BuyerService {

    public Buyer findById(Object id) {
        return null;
    }

    public Page<Buyer> findByPage(Pageable pageable) {
        return null;
    }

    public List<Buyer> findByTbIdOrNickName(String key) {
        return null;
    }

    public boolean insertOrUpdate(Buyer buyer) {
        return false;
    }
}
