package com.kelan.smallscene.bean;

import java.util.Date;

public class Permission {
    private Long sid;

    private String permissionUuid;

    private String resourceUuid;

    private String resourceTypeUuid;

    private String resourcePrivileges;

    private Date createDate;

    private Date updateDate;

    public Permission(Long sid, String permissionUuid, String resourceUuid, String resourceTypeUuid, String resourcePrivileges, Date createDate, Date updateDate) {
        this.sid = sid;
        this.permissionUuid = permissionUuid;
        this.resourceUuid = resourceUuid;
        this.resourceTypeUuid = resourceTypeUuid;
        this.resourcePrivileges = resourcePrivileges;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Permission() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getPermissionUuid() {
        return permissionUuid;
    }

    public void setPermissionUuid(String permissionUuid) {
        this.permissionUuid = permissionUuid == null ? null : permissionUuid.trim();
    }

    public String getResourceUuid() {
        return resourceUuid;
    }

    public void setResourceUuid(String resourceUuid) {
        this.resourceUuid = resourceUuid == null ? null : resourceUuid.trim();
    }

    public String getResourceTypeUuid() {
        return resourceTypeUuid;
    }

    public void setResourceTypeUuid(String resourceTypeUuid) {
        this.resourceTypeUuid = resourceTypeUuid == null ? null : resourceTypeUuid.trim();
    }

    public String getResourcePrivileges() {
        return resourcePrivileges;
    }

    public void setResourcePrivileges(String resourcePrivileges) {
        this.resourcePrivileges = resourcePrivileges == null ? null : resourcePrivileges.trim();
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