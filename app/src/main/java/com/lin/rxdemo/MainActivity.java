package com.lin.rxdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lin.rxdemo.mvp.contract.MeiMeiContract;
import com.lin.rxdemo.mvp.presenter.MeiMeiPresenter;
import com.lin.rxdemo.network.service.observers.DisposableManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MeiMeiContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onDestroy() {
        DisposableManager.dispose();
        super.onDestroy();
    }

    @Override
    public void updateContentList(List list) {
        MeiMeiPresenter meiMeiPresenter = MeiMeiPresenter.newInstance();
        meiMeiPresenter.setContext(this);
        meiMeiPresenter.initData(1);
    }
}
