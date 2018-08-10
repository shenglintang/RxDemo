package com.lin.rxdemo.mvp.presenter;

import android.content.Context;

import com.lin.rxdemo.mvp.base.BasePresenterImpl;
import com.lin.rxdemo.mvp.base.CallBackListener;
import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.mvp.model.MeiMeiModel;

public class MeiMeiPresenter extends BasePresenterImpl<MeiMeiContract.View> implements MeiMeiContract.Presenter, CallBackListener {
    private MeiMeiModel meiMeiModel;
    private Context mContext;

    public MeiMeiPresenter(Context context) {
        mContext = context;
        meiMeiModel = new MeiMeiModel(mContext);
    }


    @Override
    public void initData(int page) {
        if (meiMeiModel != null) {
            meiMeiModel.getData(page, this);
        }
    }

    @Override
    public void onSuccess(Object data) {
        if (isViewAttached()) {
            getView().updateContentList(data);
        }
    }

    @Override
    public void onFail() {

    }
}
