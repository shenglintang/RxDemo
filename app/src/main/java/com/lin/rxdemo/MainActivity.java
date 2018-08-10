package com.lin.rxdemo;

import android.widget.TextView;

import com.lin.rxdemo.mvp.base.BaseActivity;
import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.mvp.presenter.MeiMeiPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<MeiMeiPresenter> implements MeiMeiContract.View {

    private MeiMeiPresenter mMeiMeiPresenter;
    private TextView mTvInfo;


    @Override
    protected MeiMeiPresenter creatPresenter() {
        mMeiMeiPresenter = new MeiMeiPresenter(this);
        return mMeiMeiPresenter;
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTvInfo = findViewById(R.id.tv_info);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mMeiMeiPresenter.initData(1);
    }


    @Override
    public void updateContentList(Object data) {
        List<MeiMeiBean.ResultsBean> mList = new ArrayList<>();
        mList.addAll(((MeiMeiBean) data).getResults());
        mTvInfo.setText(mList.get(0).getDesc());
    }
}
