package com.neusoft.springboot1.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Goods {
    private Integer gId;
    private String gName;
    private String gIntro;
    private Integer gNum;
    private String uName;
    private String gPic;
    private Integer gStatus;
    private Timestamp addtime;
    private Integer gPrice;
    private String tName;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgIntro() {
        return gIntro;
    }

    public void setgIntro(String gIntro) {
        this.gIntro = gIntro;
    }

    public Integer getgNum() {
        return gNum;
    }

    public void setgNum(Integer gNum) {
        this.gNum = gNum;
    }



    public String getgPic() {
        return gPic;
    }

    public void setgPic(String gPic) {
        this.gPic = gPic;
    }

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Integer getgPrice() {
        return gPrice;
    }

    public void setgPrice(Integer gPrice) {
        this.gPrice = gPrice;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }
}
