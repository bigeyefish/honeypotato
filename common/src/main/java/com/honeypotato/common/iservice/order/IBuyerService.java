package com.honeypotato.common.iservice.order;

import com.honeypotato.common.bean.order.Buyer;
import com.honeypotato.common.iservice.ICommonService;

import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public interface IBuyerService extends ICommonService<Buyer> {

    /**
     * 根据淘宝id或淘宝昵称查询用户信息
     * @param key
     * @return
     */
    List<Buyer> findByTbIdOrNickName(String key);

    /**
     * 添加或更新用户信息
     * @param buyer
     * @return
     */
    boolean insertOrUpdate(Buyer buyer);

}
