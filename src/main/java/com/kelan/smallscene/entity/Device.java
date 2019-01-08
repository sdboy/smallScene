package com.kelan.smallscene.entity;

public class Device {
    private Long sid;

    private Integer id;

    private String type;

    private String name;

    private Integer manufacturer;

    private String model;

    private String ip;

    private String port;

    private String user;

    private String password;

    private String desc;

    private Integer status;

    private String loginType;

    private String regid;

    private String proxyPort;

    private Integer unitNum;

    private String deviceCn;

    private String deviceSn;

    private String deviceIp;

    private String devicePort;

    private String devMaintainer;

    private String devMaintainerPh;

    private String rights;

    public Device(Long sid, Integer id, String type, String name, Integer manufacturer, String model, String ip, String port, String user, String password, String desc, Integer status, String loginType, String regid, String proxyPort, Integer unitNum, String deviceCn, String deviceSn, String deviceIp, String devicePort, String devMaintainer, String devMaintainerPh, String rights) {
        this.sid = sid;
        this.id = id;
        this.type = type;
        this.name = name;
        this.manufacturer = manufacturer;
        this.model = model;
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
        this.desc = desc;
        this.status = status;
        this.loginType = loginType;
        this.regid = regid;
        this.proxyPort = proxyPort;
        this.unitNum = unitNum;
        this.deviceCn = deviceCn;
        this.deviceSn = deviceSn;
        this.deviceIp = deviceIp;
        this.devicePort = devicePort;
        this.devMaintainer = devMaintainer;
        this.devMaintainerPh = devMaintainerPh;
        this.rights = rights;
    }

    public Device() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Integer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType == null ? null : loginType.trim();
    }

    public String getRegid() {
        return regid;
    }

    public void setRegid(String regid) {
        this.regid = regid == null ? null : regid.trim();
    }

    public String getProxyPort() {
        return proxyPort;
    }

    public void setProxyPort(String proxyPort) {
        this.proxyPort = proxyPort == null ? null : proxyPort.trim();
    }

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public String getDeviceCn() {
        return deviceCn;
    }

    public void setDeviceCn(String deviceCn) {
        this.deviceCn = deviceCn == null ? null : deviceCn.trim();
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp == null ? null : deviceIp.trim();
    }

    public String getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(String devicePort) {
        this.devicePort = devicePort == null ? null : devicePort.trim();
    }

    public String getDevMaintainer() {
        return devMaintainer;
    }

    public void setDevMaintainer(String devMaintainer) {
        this.devMaintainer = devMaintainer == null ? null : devMaintainer.trim();
    }

    public String getDevMaintainerPh() {
        return devMaintainerPh;
    }

    public void setDevMaintainerPh(String devMaintainerPh) {
        this.devMaintainerPh = devMaintainerPh == null ? null : devMaintainerPh.trim();
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }
}