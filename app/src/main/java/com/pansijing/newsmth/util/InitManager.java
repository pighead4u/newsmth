package com.pansijing.newsmth.util;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * @author zhuhuanhuan
 * @time 2016/7/2
 * @email zhuhuanhuan@qccr.com
 * @desc
 *      初始化模块，所有的初始化都放在这里
 */
public final class InitManager {

    private InitManager() {

    }

    public static void init(Application application) {

        initAsync(application);

        initSynch(application);
    }

    private static void initAsync(Application application) {

        HttpManager.init();

        LeakCanary.install(application);

        CrashReport.initCrashReport(application, "900036889", false);
    }

    private static void initSynch(Application application) {}

}
