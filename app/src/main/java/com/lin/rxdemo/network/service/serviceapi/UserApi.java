package com.lin.rxdemo.network.service.serviceapi;


import com.lin.rxdemo.Constant;
import com.lin.rxdemo.MeiMeiBean;
import com.lin.rxdemo.network.service.HttpMethod;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

/**
 * 封装网络请求接口类
 */
public class UserApi extends BaseApi {

    public static UserApi userApi_meimei;
    public UserService userService;

    public UserApi() {
        userService = HttpMethod.createApi(UserService.class,Constant.MeiMei_URL);
    }

    public static UserApi getInstance() {
                if (userApi_meimei == null) {
                    synchronized (UserApi.class) {
                        if (null == userApi_meimei)
                            userApi_meimei = new UserApi();
                    }
                }
                return userApi_meimei;

    }

    /*-------------------------------------获取的方法-------------------------------------*/
    public void getMeiMeiInfo(int id, Observer<List<MeiMeiBean.ResultsBean>> observer) {
        Observable observable = userService.getMeiMei(id)
                .map(new HttpResultFunc<MeiMeiBean>());
        toSubscribe(observable, observer);
    }


}
