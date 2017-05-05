package com.pansijing.newsmth.model.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@hotmail.com
 * @desc
 */
public interface Top10Service {

    @GET
    Call<String> getTop10();
}
