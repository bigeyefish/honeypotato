package com.honeypotato.common.iservice;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public interface ICommonService<T> {

    /**
     * 根据id获取实体
     * @param id
     * @return
     */
    T findById(Object id);

    /**
     * 分页查询实体
     * @param pageable
     * @return
     */
    Page<T> findByPage(Pageable pageable);
}
