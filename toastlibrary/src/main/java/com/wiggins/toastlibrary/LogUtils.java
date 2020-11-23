/**
 * FileName: LogUtils
 * Author: Administrator
 * Date: 2020/11/23 0023 18:56
 * Description:
 */
package com.wiggins.toastlibrary;

import android.app.Application;
import android.content.Context;
import android.os.Debug;
import android.util.Log;

/**
 * @ClassName: LogUtils
 * @Description: java类作用描述
 * @Author: Administrator
 * @Date: 2020/11/23 0023 18:56
 */
class LogUtils {

    private static boolean logshow = false;
    private static String clark = "clark";
    private static Context context;

    //通过初始化获取上下文，并判断是否是debug模式
    public static void initLog(Context mContext) {
        context = mContext;
        logshow = !DebugUtils.isApkInDebug(context);
    }


    public static void d(String s) {
        if (logshow) {
            Log.d(clark, s);
        }
    }

    public static void e(String s) {
        if (logshow) {
            Log.e(clark, s);
        }
    }

    public static void w(String s) {
        if (logshow) {
            Log.w(clark, s);
        }
    }

    public static void v(String s) {
        if (logshow) {
            Log.v(clark, s);
        }
    }

}