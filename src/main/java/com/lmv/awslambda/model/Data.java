package com.lmv.awslambda.model;

public class Data {

    private String id;
    private String correlationId;
    private String destination;
    private String origin;
    private int campaignId;
    private String campaignAlias;
    private String flowId;
    private String extraInfo;
    private boolean sent;
    private int sentStatusCode;
    private String sentStatus;
    private String sentDate;
    private long sentAt;
    private boolean delivered;
    private int deliveredStatusCode;
    private String deliveredStatus;
    private String deliveredDate;
    private long deliveredAt;
    private boolean read;
    private String readDate;
    private long readAt;
    private String updatedDate;
    private long updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignAlias() {
        return campaignAlias;
    }

    public void setCampaignAlias(String campaignAlias) {
        this.campaignAlias = campaignAlias;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    public int getSentStatusCode() {
        return sentStatusCode;
    }

    public void setSentStatusCode(int sentStatusCode) {
        this.sentStatusCode = sentStatusCode;
    }

    public String getSentStatus() {
        return sentStatus;
    }

    public void setSentStatus(String sentStatus) {
        this.sentStatus = sentStatus;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public long getSentAt() {
        return sentAt;
    }

    public void setSentAt(long sentAt) {
        this.sentAt = sentAt;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getDeliveredStatusCode() {
        return deliveredStatusCode;
    }

    public void setDeliveredStatusCode(int deliveredStatusCode) {
        this.deliveredStatusCode = deliveredStatusCode;
    }

    public String getDeliveredStatus() {
        return deliveredStatus;
    }

    public void setDeliveredStatus(String deliveredStatus) {
        this.deliveredStatus = deliveredStatus;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public long getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(long deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getReadDate() {
        return readDate;
    }

    public void setReadDate(String readDate) {
        this.readDate = readDate;
    }

    public long getReadAt() {
        return readAt;
    }

    public void setReadAt(long readAt) {
        this.readAt = readAt;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
