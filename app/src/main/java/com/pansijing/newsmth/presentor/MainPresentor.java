package com.pansijing.newsmth.presentor;

import android.util.Log;

import com.pansijing.newsmth.model.bean.Top10;
import com.pansijing.newsmth.util.GsonManager;
import com.pansijing.newsmth.util.HttpManager;
import com.pansijing.newsmth.util.JSoupManager;
import com.pansijing.newsmth.view.IMain;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@qccr.com
 * @desc
 */
public class MainPresentor {

    private static final String TAG = MainPresentor.class.getSimpleName();

    private IMain iMain;

    public MainPresentor(IMain iMain) {
        this.iMain = iMain;
    }

    public void getTop10() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                OkHttpClient client = HttpManager.getOKHttpClient();
                Request request = new Request.Builder()
                        .url(HttpManager.HOST)
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String data = response.body().string();
                    List<Top10> top10List = JSoupManager.convert2Top10(data);
                    subscriber.onNext(GsonManager.getGson().toJson(top10List));
                } catch (IOException e) {
                    Log.e(TAG, "call: " + e);
                }
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        iMain.getTop10Failed(e.toString());
                    }

                    @Override
                    public void onNext(String s) {
                        iMain.getTop10Success(s);
                    }
                });

    }
}
