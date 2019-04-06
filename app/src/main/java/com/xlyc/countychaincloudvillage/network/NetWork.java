package com.xlyc.countychaincloudvillage.network;

import android.os.Environment;


import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.xlyc.countychaincloudvillage.api.ApiService;
import com.xlyc.countychaincloudvillage.app.MyApp;
import com.xlyc.countychaincloudvillage.network.cookie.LoggingInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWork {
    public static final String ROOT_URL = "http://47.92.97.244:2222/";

    private static ApiService apiService;


    private static final long cacheSize = 1024 * 1024 * 20;// 缓存文件最大限制大小20M
    private static String cacheDirectory = Environment.getExternalStorageDirectory() + "/okttpcaches"; // 设置缓存文件路径
    private static Cache cache = new Cache(new File(cacheDirectory), cacheSize);  //
    private static HttpLoggingInterceptor logInterceptor;

    private static OkHttpClient okHttpClient;

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    /**
     * 初始化okhttp
     */
    public static void initOkhttp() {
        if (okHttpClient == null) {
            //声明日志类
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//设定日志级别
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            ClearableCookieJar cookieJar =
                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(MyApp.getContext()));
//
            File httpCacheDirectory = new File(MyApp.getContext().getCacheDir(), "responses");
            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            //如果不是在正式包，添加拦截 打印响应json
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new LoggingInterceptor())
                    .cookieJar(cookieJar)
                    .sslSocketFactory(new SSL(new TrustAllCerts()), new TrustAllCerts())
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String s, SSLSession sslSession) {
                            return true;
                        }
                    })
//                    .addInterceptor(new AddCookiesInterceptor(context, ""))
//                    .addInterceptor(new ReceivedCookiesInterceptor(context))
                    .connectTimeout(20, TimeUnit.SECONDS)// 设置连接超时时间
                    .writeTimeout(20, TimeUnit.SECONDS)// 设置写入超时时间
                    .cache(cache)// 设置缓存
                    .readTimeout(20, TimeUnit.SECONDS)// 设置读取数据超时时间
                    .retryOnConnectionFailure(false)// 设置进行连接失败重试
                    .build();
        }

    }

    public static class TrustAllCerts implements X509TrustManager {
        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    }

    //登录
    public static ApiService getApiService() {
        initOkhttp();
        if (apiService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }
}
