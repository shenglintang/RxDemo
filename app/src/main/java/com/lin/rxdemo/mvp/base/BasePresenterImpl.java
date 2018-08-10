package com.lin.rxdemo.mvp.base;

import android.os.Bundle;

import com.lin.rxdemo.network.service.observers.DisposableManager;

import java.lang.ref.WeakReference;

/**
 * P层实现的基类
 * P层声明周期包装，view层的绑定与解除，
 *
 * @param <V>
 */
public class BasePresenterImpl<V> implements BaseContract.BasePresenter<V> {

    private WeakReference<V> mVWeakReference;

    protected V getView() {
        return mVWeakReference.get();
    }

    protected boolean isViewAttached() {
        return mVWeakReference != null && mVWeakReference.get() != null;
    }

    @Override
    public void onMvpAttachView(V view, Bundle savedInstanceState) {
        mVWeakReference = new WeakReference<>(view);
    }

    @Override
    public void onMvpStart() {

    }

    @Override
    public void onMvpResume() {

    }

    @Override
    public void onMvpPause() {

    }

    @Override
    public void onMvpStop() {

    }

    @Override
    public void onMvpSaveInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onMvpDetachView(boolean retainInstance) {
        if (mVWeakReference != null) {
            mVWeakReference.clear();
            mVWeakReference = null;
        }
    }

    @Override
    public void onMvpDestroy() {
        DisposableManager.dispose();
    }
}
