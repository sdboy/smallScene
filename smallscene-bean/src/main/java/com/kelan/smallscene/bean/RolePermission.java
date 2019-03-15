package com.kelan.smallscene.bean;

import java.util.Date;

public class RolePermission {
    private Long sid;

    private String roleUuid;

    private String permissionUuid;

    private Date createDate;

    private Date updateDate;

    public RolePermission(Long sid, String roleUuid, String permissionUuid, Date createDate, Date updateDate) {
        this.sid = sid;
        this.roleUuid = roleUuid;
        this.permissionUuid = permissionUuid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public RolePermission() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getRoleUuid() {
        return roleUuid;
    }

    public void setRoleUuid(String roleUuid) {
        this.roleUuid = roleUuid == null ? null : roleUuid.trim();
    }

    public String getPermissionUuid() {
        return permissionUuid;
    }

    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid == null ? null : permissionUuid.trim();
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