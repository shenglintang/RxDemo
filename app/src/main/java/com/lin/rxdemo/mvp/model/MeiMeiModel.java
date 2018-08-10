package com.lin.rxdemo.mvp.model;

import android.content.Context;

import com.lin.rxdemo.MeiMeiBean;
import com.lin.rxdemo.mvp.base.CallBackListener;
import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.network.service.observers.HttpObservers;
import com.lin.rxdemo.network.service.observers.ObserverOnListener;
import com.lin.rxdemo.network.service.serviceapi.UserApi;

import java.util.List;

public class MeiMeiModel implements MeiMeiContract.Model {
    private Context mContext;

    public MeiMeiModel(Context context) {
        mContext = context;
    }

    @Override
    public void getData(int page, final CallBackListener CallBackListener) {

        UserApi.getInstance().getMeiMeiInfo((page + 1), new HttpObservers<List<MeiMeiBean.ResultsBean>>(new ObserverOnListener() {

            @Override
            public void onSucceed(Object data) {
                CallBackListener.onSuccess(data);

            }

            @Override
            public void onError(int code, String msg) {
                CallBackListener.onFail();
            }
        }, mContext));
    }
}
