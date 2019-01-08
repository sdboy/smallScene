package com.kelan.smallscene.entity;

import java.util.Date;

public class Department {
    private Long sid;

    private String coding;

    private String name;

    private Date modifyTime;

    private Long maxDepId;

    private String sn;

    public Department(Long sid, String coding, String name, Date modifyTime, Long maxDepId, String sn) {
        this.sid = sid;
        this.coding = coding;
        this.name = name;
        this.modifyTime = modifyTime;
        this.maxDepId = maxDepId;
        this.sn = sn;
    }

    public Department() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding == null ? null : coding.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getMaxDepId() {
        return maxDepId;
    }

    public void setMaxDepId(Long maxDepId) {
        this.maxDepId = maxDepId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }
}