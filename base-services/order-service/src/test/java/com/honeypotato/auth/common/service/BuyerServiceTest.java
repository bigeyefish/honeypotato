package com.honeypotato.auth.common.service;

import com.honeypotato.common.dto.order.Buyer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 2018/4/14.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BuyerServiceTest {

    @Autowired
    private BuyerService buyerService;

    private Buyer buyer;
    String tbId = "123456";

    @Before
    public void setUp() throws Exception {
        buyer = new Buyer();
    }

    @After
    public void tearDown() throws Exception {
        List<Buyer> buyerList = buyerService.findByTbIdOrNickName(tbId);
        if (buyerList.size() > 0) {
            buyerService.deleteBuyId(buyerList.get(0).getId());
        }
    }

    @Test(expected = Exception.class)
    public void insertOrUpdateFromTbException() throws Exception {
        buyerService.insertOrUpdateFromTb(buyer);
        fail("无购买者基础信息没有抛出异常");
    }

    @Test
    public void insertOrUpdateFromTbSucceed() throws Exception {
        String tbId = "123456";
        buyer.setTbId(tbId);
        buyer.setTbNickName("啦啦啦");
        buyer.setPayAmount(100.5);

        boolean isInsert = buyerService.insertOrUpdateFromTb(buyer);
        assertTrue(isInsert);

        boolean isInsert1 = buyerService.insertOrUpdateFromTb(buyer);
        assertFalse(isInsert1);

        Buyer buyer1 = buyerService.findByTbId(tbId);
        assertEquals(buyer1.getPayAmount(), 100.5 * 2, 0);
        assertEquals(buyer1.getOrderQty(), 2);
    }

}