package com.kelan.smallscene.bean;

public class Channel {
    private Long sid;

    private String id;

    private String name;

    private String desc;

    private Integer status;

    private Integer channelType;

    private String channelSn;

    private String rights;

    private Integer cameraType;

    private String ctrlId;

    private Double latitude;

    private Double longitude;

    private String viewDomain;

    public Channel(Long sid, String id, String name, String desc, Integer status, Integer channelType, String channelSn, String rights, Integer cameraType, String ctrlId, Double latitude, Double longitude, String viewDomain) {
        this.sid = sid;
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.status = status;
        this.channelType = channelType;
        this.channelSn = channelSn;
        this.rights = rights;
        this.cameraType = cameraType;
        this.ctrlId = ctrlId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.viewDomain = viewDomain;
    }

    public Channel() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public Integer getChannelType() {
        return channelType;
    }

    public void setChannelType(Integer channelType) {
        this.channelType = channelType;
    }

    public String getChannelSn() {
        return channelSn;
    }

    public void setChannelSn(String channelSn) {
        this.channelSn = channelSn == null ? null : channelSn.trim();
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights == null ? null : rights.trim();
    }

    public Integer getCameraType() {
        return cameraType;
    }

    public void setCameraType(Integer cameraType) {
        this.cameraType = cameraType;
    }

    public String getCtrlId() {
        return ctrlId;
    }

    public void setCtrlId(String ctrlId) {
        this.ctrlId = ctrlId == null ? null : ctrlId.trim();
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getViewDomain() {
        return viewDomain;
    }

    public void setViewDomain(String viewDomain) {
        this.viewDomain = viewDomain == null ? null : viewDomain.trim();
    }
}