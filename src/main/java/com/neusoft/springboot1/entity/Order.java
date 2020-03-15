package com.neusoft.springboot1.entity;

import java.sql.Timestamp;

public class Order {
    private Integer oId;
    private String oName;
    private Integer oStatus ;
    private Timestamp addtime;
    private Integer payment;
    private String uName;
    private Integer uId;
    private String address;
    private float price;
    private Integer isPay;
    private Timestamp paytime;
    private Integer isSend;
    private Timestamp sendtime;
    private Integer isReceipt;
    private Timestamp receipttime;
    private String sendNumber;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

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

    public Integer getoStatus() {
        return oStatus;
    }

    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

//    public String getgName() {
//        return gName;
//    }
//
//    public void setgName(String gName) {
//        this.gName = gName;
//    }

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(Integer isReceipt) {
        this.isReceipt = isReceipt;
    }

    public Timestamp getReceipttime() {
        return receipttime;
    }

    public void setReceipttime(Timestamp receipttime) {
        this.receipttime = receipttime;
    }

    public String getSendNumber() {
        return sendNumber;
    }

    public void setSendNumber(String sendNumber) {
        this.sendNumber = sendNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId=" + oId +
                ", oName='" + oName + '\'' +
                ", oStatus=" + oStatus +
                ", addtime=" + addtime +
                ", payment=" + payment +
                ", uName='" + uName + '\'' +
                ", uId=" + uId +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", isPay=" + isPay +
                ", paytime=" + paytime +
                ", isSend=" + isSend +
                ", sendtime=" + sendtime +
                ", isReceipt=" + isReceipt +
                ", receipttime=" + receipttime +
                ", sendNumber='" + sendNumber + '\'' +
                '}';
    }

    //    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }

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
