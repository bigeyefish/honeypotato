package com.honeypotato.common.iservice.order;

import com.honeypotato.common.dto.order.Order;
import com.honeypotato.common.iservice.ICommonService;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public interface IOrderService extends ICommonService<Order>{

    /**
     * 新增或更新记录
     * @param order
     * @return 新增 true 更新 false
     */
    boolean insertOrUpdate(Order order);
}
