package com.honeypotato.dao;

import com.honeypotato.common.dto.order.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
public interface BuyerRepository extends MongoRepository<Buyer, String> {

    Page<Buyer> findAll(Pageable pageable);

    @Query(value = "{$or: [{'tbId': ?0}, {'tbNickName': ?0}]}")
    List<Buyer> findByTbIdOrNickName(String key);

    Buyer findByTbId(String tbId);
}
