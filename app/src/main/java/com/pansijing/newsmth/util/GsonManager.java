package com.pansijing.newsmth.util;

import com.google.gson.Gson;

/**
 * @author: zhuhuanhuan
 * @time: 16/7/2-下午1:28.
 * @email: zhuhuanhuan@hotmail.com
 * @desc:
 */
public final class GsonManager {

    private static Gson mGson;

    private GsonManager() {
    }

    public static void init() {
        mGson = new Gson();
    }

    public static Gson getGson() {
        return mGson;
    }
}
