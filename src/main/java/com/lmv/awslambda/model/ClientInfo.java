package com.lmv.awslambda.model;

public class ClientInfo {

    private int customerId;
    private int subAccountId;
    private int userId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getSubAccountId() {
        return subAccountId;
    }

    public void setSubAccountId(int subAccountId) {
        this.subAccountId = subAccountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
