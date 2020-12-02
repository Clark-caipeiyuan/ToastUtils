/**
 * FileName: APKVersionCodeUtils
 * Author: Administrator
 * Date: 2020/12/2 0002 9:46
 * Description:
 */
package com.wiggins.toastlibrary.AppTools;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * @ClassName: APKVersionCodeUtils
 * @Description: 获取当前应用包的版本号 版本名称
 * @Author: Clark
 * @Date: 2020/12/2 0002 9:46
 */
class APKVersionCodeUtils {
    /**
     * 获取当前本地apk的版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            // 获取apk版本号
            versionCode = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 获取版本号名称
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }
}
