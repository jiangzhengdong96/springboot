package com.neusoft.springboot1.entity;

import java.sql.Timestamp;

public class Shopcar {
    private Integer sId;
    private Integer gId;
    private String gName;
    private Integer number;
    private String gPic;
    private Integer gPrice;
    private Integer status;
    private Timestamp addtime;
    private Timestamp updatetime;
    private Integer upStatus;
    private Integer gStatus;
    private Integer gNum;
    private float sPrice;
    private Integer uId;
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public float getsPrice() {
        return sPrice;
    }

    public void setsPrice(float sPrice) {
        this.sPrice = sPrice;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getgPic() {
        return gPic;
    }

    public void setgPic(String gPic) {
        this.gPic = gPic;
    }

    public Integer getgPrice() {
        return gPrice;
    }

    public void setgPrice(Integer gPrice) {
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

    public Integer getUpStatus() {
        return upStatus;
    }

    public void setUpStatus(Integer upStatus) {
        this.upStatus = upStatus;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    @Override
    public String toString() {
        return "Shopcar{" +
                "sId=" + sId +
                ", gId=" + gId +
                ", gName='" + gName + '\'' +
                ", number=" + number +
                ", gPic='" + gPic + '\'' +
                ", gPrice=" + gPrice +
                ", status=" + status +
                ", addtime=" + addtime +
                ", updatetime=" + updatetime +
                ", upStatus=" + upStatus +
                ", gStatus=" + gStatus +
                ", gNum=" + gNum +
                ", sPrice=" + sPrice +
                ", uId=" + uId +
                '}';
    }
}
