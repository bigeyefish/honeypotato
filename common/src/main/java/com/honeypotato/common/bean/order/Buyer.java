package com.honeypotato.common.bean.order;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 购买者
 * Created by sanyihwang on 2018/4/12.
 */
public class Buyer {

    @Id
    private String id;

    private String tbId;

    private String nickName;

    private String tbNickName;

    /* 渠道 1-淘宝；2-微信 */
    private int channel;

    /* 支付总金额 */
    private double payAmount;

    private Date createDt;

    private Date updateDt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTbId() {
        return tbId;
    }

    public void setTbId(String tbId) {
        this.tbId = tbId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTbNickName() {
        return tbNickName;
    }

    public void setTbNickName(String tbNickName) {
        this.tbNickName = tbNickName;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id='" + id + '\'' +
                ", tbId='" + tbId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", tbNickName='" + tbNickName + '\'' +
                ", channel=" + channel +
                ", payAmount=" + payAmount +
                ", createDt=" + createDt +
                ", updateDt=" + updateDt +
                '}';
    }
}
