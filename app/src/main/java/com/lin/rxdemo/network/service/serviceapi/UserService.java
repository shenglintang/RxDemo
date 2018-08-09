package com.lin.rxdemo.network.service.serviceapi;


import com.lin.rxdemo.MeiMeiBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * retrofit接口
 */
public interface UserService {

    @GET("/api/data/福利/10/{page}")
    Observable<MeiMeiBean> getMeiMei(@Path("page") int page);

}
