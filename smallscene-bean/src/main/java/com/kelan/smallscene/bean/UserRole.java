package com.kelan.smallscene.bean;

import java.util.Date;

public class UserRole {
    private Long sid;

    private String userUuid;

    private String roleUuid;

    private Date createDate;

    private Date updateDate;

    public UserRole(Long sid, String userUuid, String roleUuid, Date createDate, Date updateDate) {
        this.sid = sid;
        this.userUuid = userUuid;
        this.roleUuid = roleUuid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public UserRole() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}