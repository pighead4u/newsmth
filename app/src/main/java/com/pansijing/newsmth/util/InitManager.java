package com.pansijing.newsmth.util;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

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

    private static void initAsync(Application application) {

        Log.d(TAG, "initAsync: ");

        HttpManager.init();

        GsonManager.init();

        LeakCanary.install(application);

        CrashReport.initCrashReport(application, "900036889", false);
    }

    private static void initSynch(Application application) {}

}
