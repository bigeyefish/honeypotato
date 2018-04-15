package com.honeypotato.service;

import com.honeypotato.common.Constant;
import com.honeypotato.common.dto.order.Buyer;
import com.honeypotato.dao.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * 购买者服务类
 * Created by sanyihwang on 2018/4/12.
 */
@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> findByTbIdOrNickName(String key) {
//        buyerRepository.findAll();
        return null;
    }

    /**
     * 添加或更新买家信息（不存在则添加，存在则累加消费金额和订单数）
     * @param buyer 购买者信息
     * @return 新增返回true 修改返回false
     */
    public boolean insertOrUpdateFromTb(Buyer buyer) {
        Assert.state(buyer.getTbId() != null && buyer.getTbNickName() != null, "淘宝账号和淘宝昵称不能为空");
        Buyer buyer1 = buyerRepository.findByTbId(buyer.getTbId());

        if (null != buyer1) {
            buyer1.setNickName(buyer.getNickName());
            buyer1.setOrderQty(buyer1.getOrderQty() + 1);
            buyer1.setPayAmount(buyer1.getPayAmount() + buyer.getPayAmount());
            buyer1.setUpdateDt(new Date());
            return false;
        } else {
            buyer.setChannel(Constant.OrderChannel.TAOBAO);
            buyerRepository.insert(buyer);
            return true;
        }
    }
}
