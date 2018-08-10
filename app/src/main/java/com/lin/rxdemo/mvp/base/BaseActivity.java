package com.lin.rxdemo.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 *Activity基类
 */
public abstract class BaseActivity<P extends BaseContract.BasePresenter> extends AppCompatActivity implements BaseContract.BaseView {

    protected P mPresenter;

    protected abstract P creatPresenter();

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        mPresenter = creatPresenter();
        if (mPresenter != null) {
            mPresenter.onMvpAttachView(this, savedInstanceState);
        }
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onMvpSaveInstanceState(outState);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mPresenter != null) {
            mPresenter.onMvpResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mPresenter != null) {
            mPresenter.onMvpPause();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onMvpDetachView(false);
            mPresenter.onMvpDestroy();
        }
    }
}
