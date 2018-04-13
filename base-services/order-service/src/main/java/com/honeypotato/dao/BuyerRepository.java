package com.honeypotato.dao;

import com.honeypotato.common.dto.order.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public interface BuyerRepository extends MongoRepository<Buyer, Long> {

    @Override
    Page<Buyer> findAll(Pageable pageable);
}
