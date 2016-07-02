package com.pansijing.newsmth.presentor;

import com.pansijing.newsmth.model.network.Top10Service;
import com.pansijing.newsmth.util.HttpManager;
import com.pansijing.newsmth.view.IMain;

import java.io.IOException;

import retrofit2.Call;
import rx.Observable;
import rx.Subscriber;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@qccr.com
 * @desc
 */
public class MainPresentor {

    private IMain iMain;

    public MainPresentor(IMain iMain) {
        this.iMain = iMain;
    }

    public void getTop10() throws IOException {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                Top10Service top10Service = HttpManager.getRetrofit().create(Top10Service.class);
                Call<String> result = top10Service.getTop10();
                result.execute().body();
            }
        })
        Top10Service top10Service = HttpManager.getRetrofit().create(Top10Service.class);
        Call<String> result = top10Service.getTop10();
        return result.execute().body();
    }
}
