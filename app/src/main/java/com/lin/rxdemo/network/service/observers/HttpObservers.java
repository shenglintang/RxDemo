package com.lin.rxdemo.network.service.observers;

import android.content.Context;

import com.lin.rxdemo.network.service.ExceptionApi;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 处理网络请求类
 * 这里我们选择Observer来作为订阅者
 * 因为数据量少且不会产生移动端数据处理来不及的问题，采用Flowable的话，其运行效率要比 Observable 低得多。
 * @param <T>
 */
public class HttpObservers<T> implements Observer<T> {
    private Context mContext;
    private ObserverOnListener mObserverOnListener;
    private Disposable mDisposable;

    public HttpObservers(ObserverOnListener observerOnListener,Context context) {
        mContext = context;
        mObserverOnListener = observerOnListener;
    }

    public void onUnsubscribe() {
        DisposableManager.dispose();
    }

    @Override
    public void onSubscribe(Disposable d) {
        DisposableManager.add(d);
    }

    @Override
    public void onNext(T t) {
        if (mObserverOnListener != null && mContext != null) {
            mObserverOnListener.onSucceed(t);
        } else {
            onUnsubscribe();
        }
    }

    @Override
    public void onError(Throwable e) {
        if (mObserverOnListener != null && mContext != null) {
            if (e instanceof SocketTimeoutException) {
                mObserverOnListener.onError(-1001, "网络超时，请检查您的网络状态");
            } else if (e instanceof ConnectException) {
                mObserverOnListener.onError(-1002, "网络链接中断，请检查您的网络状态");
            } else if (e instanceof ExceptionApi) {
                mObserverOnListener.onError(((ExceptionApi) e).getCode(), ((ExceptionApi) e).getMsg());
            } else {
                mObserverOnListener.onError(-1003, "未知错误:" + e.getMessage());
            }
        } else {
            onUnsubscribe();
        }
    }

    @Override
    public void onComplete() {
        if (mObserverOnListener != null && mContext != null) {
            //subscriberOnListener.onError("完成", 1);
        } else {
            onUnsubscribe();
        }
    }
}
