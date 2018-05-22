package com.example.a.shoppingmallbymark.app;

import android.app.Application;
import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Mark栋 on 2018/4/20.
 * purpose:
 */

public class MyApplication extends Application {

    public static Context getContext() {
        return mContext;
    }

    private  static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        initOkhttpClient();
    }

    private void initOkhttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
}
