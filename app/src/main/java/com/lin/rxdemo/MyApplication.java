package com.lin.rxdemo;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    protected static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }
}
