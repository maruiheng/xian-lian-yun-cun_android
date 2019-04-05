package com.xlyc.countychaincloudvillage.network.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by mrh on 2018/3/9.
 */

public class ReceivedCookiesInterceptor implements Interceptor {

    private Context context;
    SharedPreferences sharedPreferences;

    public ReceivedCookiesInterceptor(Context context) {
        super();
        this.context = context;
        sharedPreferences = context.getSharedPreferences("jinglitongcookie", Context.MODE_PRIVATE);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain == null) {
            Log.d("httpssss", "Receivedchain == null");
        }
        Response originalResponse = chain.proceed(chain.request());
        Log.d("httpssss", "originalResponse      " + originalResponse.toString());
        if (!originalResponse.headers("set-cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            Observable.from(originalResponse.headers("set-cookie"))
                    .map(new Func1<String, String>() {
                        @Override
                        public String call(String s) {
                            String[] cookieArray = s.split(";");
                            return cookieArray[0];
                        }
                    })
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String cookie) {
                            cookieBuffer.append(cookie).append(";");
                        }
                    });
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cookie", cookieBuffer.toString());
            Log.d("httpssss", "ReceivedCookiesInterceptor   " + cookieBuffer.toString());
            editor.commit();
        }

        return originalResponse;
    }
}
