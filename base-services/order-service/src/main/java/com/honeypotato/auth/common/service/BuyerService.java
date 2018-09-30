package com.honeypotato.auth.common.service;

import com.honeypotato.auth.common.Constant;
import com.honeypotato.auth.common.dao.BuyerRepository;
import com.honeypotato.common.dto.order.Buyer;
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

    private final BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    /**
     * 删除购买者信息
     * @param id 主键
     */
    void deleteBuyId(String id) {
        buyerRepository.deleteById(id);
    }

    /**
     * 根据淘宝id或淘宝昵称查询购买者信息
     * @param key 淘宝id或昵称
     * @return 购买者列表
     */
    public List<Buyer> findByTbIdOrNickName(String key) {
        return buyerRepository.findByTbIdOrNickName(key);
    }

    /**
     * 根据淘宝id查询购买者信息
     * @param tbId 淘宝id
     * @return 购买者数据
     */
    public Buyer findByTbId(String tbId) {
        return buyerRepository.findByTbId(tbId);
    }

    /**
     * 添加或更新买家信息（不存在则添加，存在则累加消费金额和订单数）
     * @param buyer 购买者信息
     * @return 新增返回true 修改返回false
     */
    public boolean insertOrUpdateFromTb(Buyer buyer) {
        Assert.state(buyer != null && buyer.getTbId() != null && buyer.getTbNickName() != null, "淘宝账号和淘宝昵称不能为空");
        Buyer buyer1 = buyerRepository.findByTbId(buyer.getTbId());

        if (null != buyer1) {
            buyer1.setNickName(buyer.getNickName());
            buyer1.setOrderQty(buyer1.getOrderQty() + 1);
            buyer1.setPayAmount(buyer1.getPayAmount() + buyer.getPayAmount());
            buyer1.setUpdateDt(new Date());
            buyerRepository.save(buyer1);
            return false;
        } else {
            buyer.setChannel(Constant.OrderChannel.TAOBAO);
            buyer.setOrderQty(1);
            buyerRepository.insert(buyer);
            return true;
        }
    }
}
