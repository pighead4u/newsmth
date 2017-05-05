package com.pansijing.newsmth.util;

import okhttp3.OkHttpClient;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@hotmail.com
 * @desc
 */
public final class HttpManager {

    public static final String HOST = "http://m.newsmth.net";

    private static OkHttpClient mOKHttpClient = null;

    private HttpManager() {}

    public static void init() {
        mOKHttpClient = new OkHttpClient();
    }

    public static OkHttpClient getOKHttpClient() {
        return mOKHttpClient;
    }
}
