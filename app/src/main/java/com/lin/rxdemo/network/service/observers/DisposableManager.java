package com.lin.rxdemo.network.service.observers;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * 订阅管理类
 *
 */
public class DisposableManager {
    private static CompositeDisposable compositeDisposable;

    /**
     * 订阅时将Disposable添加到compositeDisposable中
     * @param disposable
     */
    public static void add(Disposable disposable) {
        getCompositeDisposable().add(disposable);
    }

    /**
     * 在页面ondestory时，取消订阅
     */
    public static void dispose() {
        getCompositeDisposable().dispose();
    }

    private static CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null || compositeDisposable.isDisposed()) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }

    private DisposableManager() {}
}
