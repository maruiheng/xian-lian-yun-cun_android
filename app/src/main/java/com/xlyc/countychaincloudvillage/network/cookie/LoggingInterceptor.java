package com.xlyc.countychaincloudvillage.network.cookie;

import com.socks.library.KLog;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by mrh on 2018/3/12.
 */

public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //Chain 里包含了request和response
        Request request = chain.request();
        long t1 = System.nanoTime();//请求发起的时间
        KLog.i(String.format("发送请求 %s on %s%n%s",request.url(),chain.connection(),request.headers()));
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();//收到响应的时间
        //不能直接使用response.body（）.string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，
        // 我们需要创建出一个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        KLog.i(String.format("接收响应：[%s] %n返回json:%s  %.1fms%n%s",
                response.request().url(),
                responseBody.string(),
                (t2-t1) /1e6d,
                response.headers()
        ));
        return response;
    }
}
