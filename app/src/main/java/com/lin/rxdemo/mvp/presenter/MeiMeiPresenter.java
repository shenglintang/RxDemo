package com.lin.rxdemo.mvp.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lin.rxdemo.MeiMeiBean;
import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.mvp.model.MeiMeiModel;

import java.util.ArrayList;
import java.util.List;

public class MeiMeiPresenter implements MeiMeiContract.Presenter {
    List<MeiMeiBean.ResultsBean> mList = new ArrayList<>();
    MeiMeiModel meiMeiModel = MeiMeiModel.newInstance();
    private Context mContext;

    @NonNull
    public static MeiMeiPresenter newInstance() {
        return new MeiMeiPresenter();
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public List initData(int page) {
        meiMeiModel.setContext(mContext);
        return  meiMeiModel.getData(page);
    }
}
