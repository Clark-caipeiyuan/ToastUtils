/**
 * FileName: DebugUtils
 * Author: Administrator
 * Date: 2020/11/23 0023 19:10
 * Description:
 */
package com.wiggins.toastlibrary;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/**
 * @ClassName: DebugUtils
 * @Description: 判断当前应用是否是debug包
 * @Author: Administrator
 * @Date: 2020/11/23 0023 19:10
 */
class DebugUtils {

    /**
     * 判断当前应用是否是debug状态
     */
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     *检测其他应用是否处于debug模式。
     */
    public static boolean isApkDebugable(Context context,String packageName) {
        try {
            PackageInfo pkginfo = context.getPackageManager().getPackageInfo(
                    packageName, 1);
            if (pkginfo != null ) {
                ApplicationInfo info= pkginfo.applicationInfo;
                return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
            }
        } catch (Exception e) {

        }
        return false;
    }





}