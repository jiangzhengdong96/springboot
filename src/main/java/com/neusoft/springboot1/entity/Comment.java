package com.neusoft.springboot1.entity;

import java.sql.Timestamp;

public class Comment {
    private Integer cId;
    private String cIntro;
    private Integer uId;
    private Integer gId;
    private String uName;
    private String gName;
    private Integer status;
    private Timestamp addtime;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcIntro() {
        return cIntro;
    }

    public void setcIntro(String cIntro) {
        this.cIntro = cIntro;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "cId=" + cId +
                ", cIntro='" + cIntro + '\'' +
                ", uId=" + uId +
                ", gId=" + gId +
                ", uName='" + uName + '\'' +
                ", gName='" + gName + '\'' +
                ", status=" + status +
                ", addtime=" + addtime +
                '}';
    }
}
