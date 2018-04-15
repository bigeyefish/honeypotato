package com.honeypotato.common.iservice.order;

import com.honeypotato.common.dto.order.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
@RequestMapping("/buyer")
public interface IBuyerService {

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    Buyer findById(Object id);

    /**
     * 分页查询实体
     * @param pageable
     * @return
     */
    Page<Buyer> findByPage(Pageable pageable);

    /**
     * 根据淘宝id或淘宝昵称查询用户信息
     * @param key
     * @return
     */
    @GetMapping("/findByTbIdOrNickName/{key}")
    List<Buyer> findByTbIdOrNickName(@PathVariable("key") String key);

    /**
     * 添加或更新用户信息
     * @param buyer
     * @return
     */
    @PostMapping
    boolean insertOrUpdate(Buyer buyer);

}
