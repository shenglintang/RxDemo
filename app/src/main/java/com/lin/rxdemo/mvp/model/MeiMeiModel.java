package com.lin.rxdemo.mvp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.lin.rxdemo.MeiMeiBean;
import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.network.service.observers.HttpObservers;
import com.lin.rxdemo.network.service.observers.ObserverOnListener;
import com.lin.rxdemo.network.service.serviceapi.UserApi;

import java.util.ArrayList;
import java.util.List;

public class MeiMeiModel implements MeiMeiContract.Model {
    private Context mContext;

    public void setContext(Context context) {
        mContext = context;
    }

    @NonNull
    public static MeiMeiModel newInstance() {
        return new MeiMeiModel();
    }

    @Override
    public List getData(int page) {
        final List<MeiMeiBean.ResultsBean> mList = new ArrayList<>();
        UserApi.getInstance().getMeiMeiInfo((page + 1), new HttpObservers<List<MeiMeiBean.ResultsBean>>(new ObserverOnListener() {

            @Override
            public void onSucceed(Object data) {
                mList.addAll(((MeiMeiBean) data).getResults());
                Log.e("lin", "mList111= " + mList);
            }

            @Override
            public void onError(int code, String msg) {
                Log.e("lin", "code= " + code);
            }
        }, mContext));
        Log.e("lin", "mList= " + mList);
        return mList;
    }
}
