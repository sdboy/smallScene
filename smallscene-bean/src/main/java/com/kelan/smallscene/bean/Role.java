package com.kelan.smallscene.bean;

import java.util.Date;

public class Role {
    private Long sid;

    private String roleName;

    private String createManUuid;

    private String roleUuid;

    private Date createDate;

    private Date updateDate;

    public Role(Long sid, String roleName, String createManUuid, String roleUuid, Date createDate, Date updateDate) {
        this.sid = sid;
        this.roleName = roleName;
        this.createManUuid = createManUuid;
        this.roleUuid = roleUuid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Role() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getCreateManUuid() {
        return createManUuid;
    }

    public void setCreateManUuid(String createManUuid) {
        this.createManUuid = createManUuid == null ? null : createManUuid.trim();
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