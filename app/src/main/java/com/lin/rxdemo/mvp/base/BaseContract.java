package com.lin.rxdemo.mvp.base;

import android.os.Bundle;

public interface BaseContract {
    interface BaseView {
    }

    interface BasePresenter<V> {
        void onMvpAttachView(V view, Bundle savedInstanceState);

        void onMvpStart();

        void onMvpResume();

        void onMvpPause();

        void onMvpStop();

        void onMvpSaveInstanceState(Bundle savedInstanceState);

        void onMvpDetachView(boolean retainInstance);

        void onMvpDestroy();
    }
}
