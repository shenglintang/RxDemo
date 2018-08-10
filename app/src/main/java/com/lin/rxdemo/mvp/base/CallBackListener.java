package com.lin.rxdemo.mvp.base;

/**
 * 通过回调链接M层与P层
 */
public interface CallBackListener<T> {
    void onSuccess(T t);

    void onFail();
}
