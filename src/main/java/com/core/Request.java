package com.core;

public class Request {
    /**
     * 请求消息
     */
    private String req;

    public Request(String req) {
        this.req = req;
    }

    public String getReq() {
        return req;
    }

    @Override
    public String toString() {
        return this.req;
    }
}
