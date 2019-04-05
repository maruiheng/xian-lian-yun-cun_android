package com.xlyc.countychaincloudvillage.network.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by mrh on 2018/3/9.
 */

public class AddCookiesInterceptor implements Interceptor {
    private Context context;
    private String lang;

    public AddCookiesInterceptor(Context context, String lang) {
        super();
        this.context = context;
        this.lang = lang;

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain == null){
            Log.d("httpssss", "Addchain == null");
        }
        final Request.Builder builder = chain.request().newBuilder();
        SharedPreferences sharedPreferences = context.getSharedPreferences("jinglitongcookie", Context.MODE_PRIVATE);
        Observable.just(sharedPreferences.getString("cookie", ""))
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String cookie) {
                        if (cookie.contains("lang=ch")){
                            cookie = cookie.replace("lang=ch","lang="+lang);
                        }
                        if (cookie.contains("lang=en")){
                            cookie = cookie.replace("lang=en","lang="+lang);
                        }
                        //添加cookie
                        Log.d("httpssss", "AddCookiesInterceptor"     +cookie);
                        builder.addHeader("cookie", cookie);
                    }
                });
        return chain.proceed(builder.build());

    }
}
