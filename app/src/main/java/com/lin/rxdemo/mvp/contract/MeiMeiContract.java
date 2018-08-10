package com.lin.rxdemo.mvp.contract;

import java.util.List;

public interface MeiMeiContract {
    interface Model<T> {
        List<T> getData(int page);
    }

    interface View<L> {
        void updateContentList(List<L> list);
    }

    interface Presenter<L> {
        List<L> initData(int page);
    }
}
