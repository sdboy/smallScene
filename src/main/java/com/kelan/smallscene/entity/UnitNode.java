package com.kelan.smallscene.entity;

public class UnitNode {
    private Long sid;

    private String index;

    private Integer channelNum;

    private String streamType;

    private String subType;

    private Integer type;

    public UnitNode(Long sid, String index, Integer channelNum, String streamType, String subType, Integer type) {
        this.sid = sid;
        this.index = index;
        this.channelNum = channelNum;
        this.streamType = streamType;
        this.subType = subType;
        this.type = type;
    }

    public UnitNode() {
        super();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index == null ? null : index.trim();
    }

    public Integer getChannelNum() {
        return channelNum;
    }

    public void setChannelNum(Integer channelNum) {
        this.channelNum = channelNum;
    }

    public String getStreamType() {
        return streamType;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType == null ? null : streamType.trim();
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}