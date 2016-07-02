package com.pansijing.newsmth;

import android.app.Application;
import android.os.StrictMode;

import com.pansijing.newsmth.util.InitManager;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@qccr.com
 * @desc 水木客户端application
 */
public class SMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        enabledStrictMode();

        InitManager.init(this);
    }

    private void enabledStrictMode() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                    .detectAll() //
                    .penaltyLog() //
                    .penaltyDeath() //
                    .build());
        }
    }
}
