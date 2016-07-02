package com.pansijing.newsmth.util;

import retrofit2.Retrofit;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@qccr.com
 * @desc
 */
public final class HttpManager {

    static final String HOST = "http://m.newsmth.net";

    private static Retrofit mRetrofit = null;

    private HttpManager() {}

    public static void init() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HOST)
                .build();
    }

    public static Retrofit getRetrofit() {
        return mRetrofit;
    }
}
