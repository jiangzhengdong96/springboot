package com.neusoft.springboot1.entity;

import java.sql.Timestamp;

public class OrderGoods {
    private Integer id;
    private String gName;
    private Integer num;
    private float gPrice;
    private Integer status;
    private Timestamp addtime;
    private Timestamp updatetime;
    private Integer gId;
    private Integer oId;

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

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", gName='" + gName + '\'' +
                ", num=" + num +
                ", gPrice=" + gPrice +
                ", status=" + status +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", gId=" + gId +
                ", oId=" + oId +
                '}';
    }
}
