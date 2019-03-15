package com.kelan.smallscene.bean;

import java.util.Date;

public class User {
    private Long sid;

    private String userAccount;

    private String userPwd;

    private String userUuid;

    private Date createDate;

    private Date updateDate;

    public User(Long sid, String userAccount, String userPwd, String userUuid, Date createDate, Date updateDate) {
        this.sid = sid;
        this.userAccount = userAccount;
        this.userPwd = userPwd;
        this.userUuid = userUuid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public User() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid == null ? null : userUuid.trim();
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