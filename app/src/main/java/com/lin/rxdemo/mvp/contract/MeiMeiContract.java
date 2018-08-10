package com.lin.rxdemo.mvp.contract;

import com.lin.rxdemo.mvp.base.BaseContract;
import com.lin.rxdemo.mvp.base.CallBackListener;

public interface MeiMeiContract {
    interface Model<T> {
        void getData(int page,CallBackListener<T> CallBackListener);
    }

    interface View<L> extends BaseContract.BaseView{
        void updateContentList(L l);
    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        void initData(int page);
    }
}
