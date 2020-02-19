package com.neusoft.springboot1.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private Integer oId;
    private String oName;
    private Integer status ;
    private Timestamp addtime;
    private String gName;
    private Integer payment;
    private String uName;
    private String address;
    private Integer price;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public Integer getgId() {
//        return gId;
//    }
//
//    public void setgId(Integer gId) {
//        this.gId = gId;
//    }
//
//    public Integer getuId() {
//        return uId;
//    }
//
//    public void setuId(Integer uId) {
//        this.uId = uId;
//    }
}
