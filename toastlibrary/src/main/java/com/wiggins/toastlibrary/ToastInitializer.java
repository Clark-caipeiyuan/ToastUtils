package com.wiggins.toastlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/**
 * @Description 初始化操作
 * @Author 一花一世界
 */
public class ToastInitializer {

    public static Context appContext;// application context
    public static Handler mainHandler = new Handler(Looper.getMainLooper());// 主线程的Handler

    /**
     * @Description 使用依赖库时必须在Application的onCreate方法中显式调用ToastInitializer.initializer(this);
     */
    public static void initializer(Context context) {
        if (null != context) {
            appContext = context;
        }
    }

    public static void runOnUiThread(Runnable task) {
        mainHandler.post(task);
    }

    public static void runOnUiThreadDelayed(Runnable task, long miliis) {
        mainHandler.postDelayed(task, miliis);
    }
}
