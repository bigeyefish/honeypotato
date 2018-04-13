package com.honeypotato.dao;

import com.honeypotato.common.dto.order.Buyer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by sanyihwang on 2018/4/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerRepositoryTest {

    @Autowired
    private BuyerRepository buyerRepository;

    @Before
    public void setUp() throws Exception {
//        buyerRepository.deleteAll();
    }

    @Test
    public void insert() throws Exception {
        Buyer buyer = new Buyer();
        buyer.setChannel(1);
        buyer.setNickName("喜洋洋");
        Buyer buyer1 = buyerRepository.insert(buyer);
    }

    @Test
    public void findAll() throws Exception {

        List<Buyer> buyerList = buyerRepository.findAll();
        System.out.println(buyerList.size());
    }

}