package com.xlyc.countychaincloudvillage.network;


import com.xlyc.countychaincloudvillage.model.request.LoginRequest;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by mrh on 2018/3/7.
 */

public interface LoginApi {

    @POST("customer/login.json")
    Observable<LoginResponse> getLoginmessage(@Body LoginRequest username);

    @POST("customer/login.json")
    Observable<LoginResponse> getLoginmessage1(@Body LoginRequest username);

}
