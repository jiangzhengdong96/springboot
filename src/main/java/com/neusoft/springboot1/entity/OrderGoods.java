package com.neusoft.springboot1.entity;

import java.sql.Timestamp;

public class OrderGoods {
    private Integer id;
    private String gName;
    private String tele;
    private String uName;
    private Integer num;
    private String gPic;
    private float gPrice;
    private Integer status;
    private Timestamp addtime;
    private Timestamp updatetime;
    private Integer gId;
    private Integer oId;
    private Integer isCommented;
    private String oName;
    private Integer oStatus;
    private  Integer payment;
    private float price;
    private String address;
    private Integer isPay;
    private Timestamp paytime;
    private Integer isSend;
    private Timestamp sendtime;
    private Integer isReceipt;
    private Timestamp receipttime;
    private String sendNumber;
    private Integer isDeal;
    private Integer gStatus;

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Integer getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(Integer isDeal) {
        this.isDeal = isDeal;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public float getgPrice() {
        return gPrice;
    }

    public void setgPrice(float gPrice) {
        this.gPrice = gPrice;
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

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public String getgPic() {
        return gPic;
    }

    public void setgPic(String gPic) {
        this.gPic = gPic;
    }

    public Integer getIsCommented() {
        return isCommented;
    }

    public void setIsCommented(Integer isCommented) {
        this.isCommented = isCommented;
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

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", gName='" + gName + '\'' +
                ", tele='" + tele + '\'' +
                ", uName='" + uName + '\'' +
                ", num=" + num +
                ", gPic='" + gPic + '\'' +
                ", gPrice=" + gPrice +
                ", status=" + status +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", gId=" + gId +
                ", oId=" + oId +
                ", isCommented=" + isCommented +
                ", oName='" + oName + '\'' +
                ", oStatus=" + oStatus +
                ", payment=" + payment +
                ", price=" + price +
                ", address='" + address + '\'' +
                ", isPay=" + isPay +
                ", paytime=" + paytime +
                ", isSend=" + isSend +
                ", sendtime=" + sendtime +
                ", isReceipt=" + isReceipt +
                ", receipttime=" + receipttime +
                ", sendNumber='" + sendNumber + '\'' +
                ", isDeal=" + isDeal +
                ", gStatus=" + gStatus +
                '}';
    }
}
