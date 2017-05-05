package com.pansijing.newsmth.util;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@hotmail.com
 * @desc
 *      初始化模块，所有的初始化都放在这里
 */
public final class InitManager {

    private static final String TAG = InitManager.class.getSimpleName();

    private InitManager() {

    }

    public static void init(Application application) {

        initAsync(application);

        initSynch(application);
    }

    private static void initAsync(final Application application) {

        Log.d(TAG, "initAsync: ");
        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override public void subscribe(@NonNull ObservableEmitter<Boolean> emitter)
                throws Exception {
                HttpManager.init();

                GsonManager.init();

                LeakCanary.install(application);

                CrashReport.initCrashReport(application, "900036889", false);

                emitter.onNext(true);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Consumer<Boolean>() {
            @Override public void accept(@NonNull Boolean aBoolean) throws Exception {
                Log.e(TAG, "accept: success");
            }
        });


    }

    private static void initSynch(Application application) {}

}
