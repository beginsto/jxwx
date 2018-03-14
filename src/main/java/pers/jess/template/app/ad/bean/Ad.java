package pers.jess.template.app.ad.bean;

import java.util.Date;

public class Ad {

    private Integer id;

    private Integer userid;

    private Integer mid;

    private String img;

    private String imgpre;

    private Date gmtCreate;

    private Integer ordernum;

    private Integer state;

    private Integer isDeleted;

    private Date gmtDeleted;

    private Integer orgid;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getImgpre() {
        return imgpre;
    }

    public void setImgpre(String imgpre) {
        this.imgpre = imgpre == null ? null : imgpre.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtDeleted() {
        return gmtDeleted;
    }

    public void setGmtDeleted(Date gmtDeleted) {
        this.gmtDeleted = gmtDeleted;
    }

    public Integer getOrgid() {
        return orgid;
    }

    public void setOrgid(Integer orgid) {
        this.orgid = orgid;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
