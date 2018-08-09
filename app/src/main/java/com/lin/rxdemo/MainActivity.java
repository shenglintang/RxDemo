package com.lin.rxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lin.rxdemo.network.service.observers.HttpObservers;
import com.lin.rxdemo.network.service.observers.ObserverOnListener;
import com.lin.rxdemo.network.service.serviceapi.UserApi;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MeiMeiBean.ResultsBean> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData(1);
    }

    public List<MeiMeiBean.ResultsBean> getData(final int page) {

        UserApi.getInstance().getMeiMeiInfo((page + 1), new HttpObservers<List<MeiMeiBean.ResultsBean>>(new ObserverOnListener() {

            @Override
            public void onSucceed(Object data) {
                mList.addAll(((MeiMeiBean) data).getResults());
                Log.e("lin", "data= " + mList.toString());
            }

            @Override
            public void onError(int code, String msg) {
                Log.e("lin", "code= " + code);
            }
        }, MainActivity.this));
        return null;
    }
}
