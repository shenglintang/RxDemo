package com.lin.rxdemo.network.service.observers;

/**
 * 网络请求监听类
 */
public interface ObserverOnListener<T> {

    void onSucceed(T data);

    void onError(int code, String msg);

}
