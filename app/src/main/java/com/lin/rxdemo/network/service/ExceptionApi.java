package com.lin.rxdemo.network.service;


/**
 * 网络请求异常类
 */
public class ExceptionApi extends RuntimeException {

    private int code;
    private String msg;

    public ExceptionApi(int resultCode, String msg) {
        this.code = resultCode;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
