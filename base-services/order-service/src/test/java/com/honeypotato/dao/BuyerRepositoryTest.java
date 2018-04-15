package com.honeypotato.dao;

import com.honeypotato.common.Constant;
import com.honeypotato.common.dto.order.Buyer;
import org.junit.Assert;
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

    private Buyer insert = new Buyer();
    private String insertNickName = "我是流氓我怕谁";
    private String insertId = "SKSH34535SLJ";

    @Before
    public void setUp() throws Exception {
//        buyerRepository.deleteAll();
        insert.setChannel(Constant.OrderChannel.TAOBAO);
        insert.setTbNickName(insertNickName);
        insert.setTbId(insertId);
        insert.setPayAmount(100);
        insert.setOrderQty(1);
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

    @Test
    public void findByTbIdOrNickName() throws Exception {
        Buyer buyer1 = buyerRepository.insert(this.insert);
        Assert.assertNotNull(buyer1.getId());

        List<Buyer> buyerList1 = buyerRepository.findByTbIdOrNickName(insertNickName);
        Assert.assertTrue(buyerList1.size() > 0);
        Assert.assertEquals(buyerList1.get(0).getTbNickName(), insertNickName);
        Assert.assertEquals(buyerList1.get(0).getTbId(), insertId);

        List<Buyer> buyerList2 = buyerRepository.findByTbIdOrNickName(insertId);
        Assert.assertTrue(buyerList2.size() > 0);
        Assert.assertEquals(buyerList2.get(0).getTbNickName(), insertNickName);
        Assert.assertEquals(buyerList2.get(0).getTbId(), insertId);

        List<Buyer> buyerList3 = buyerRepository.findByTbIdOrNickName("do not exist");
        Assert.assertEquals(buyerList3.size(), 0);

        buyerRepository.deleteById(buyer1.getId());
    }

    @Test
    public void findByTbId() throws Exception {
        Buyer buyer1 = buyerRepository.insert(this.insert);
        Assert.assertNotNull(buyer1.getId());

        Buyer buyer2 = buyerRepository.findByTbId(this.insertId);
        Assert.assertEquals(buyer1.getTbId(), buyer2.getTbId());

        Buyer buyer3 = buyerRepository.findByTbId("do not exist");
        Assert.assertNull(buyer3);

        buyerRepository.deleteById(buyer1.getId());
    }
}