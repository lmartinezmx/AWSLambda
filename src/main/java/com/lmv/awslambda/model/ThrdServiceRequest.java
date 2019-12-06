package com.lmv.awslambda.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;


public class ThrdServiceRequest {

    private int total;
    private List<Data> data;
    private ClientInfo clientInfo;

    public ThrdServiceRequest(String json) {

        Gson gson = new Gson();
        ThrdServiceRequest request = gson.fromJson(json, ThrdServiceRequest.class);
        this.total = request.getTotal();
        this.data = request.getData();
        this.clientInfo = request.getClientInfo();
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
