package net.cryallen.androidlib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * Created by chenran3 on 2017/12/12.
 */

public class AppUtil {

    /**
     * 获取软件版本
     */
    public static int getAppVersion(Context context) {
        if(null == getPackageInfo(context)){
            return 0;
        }
        return getPackageInfo(context).versionCode;
    }

    /**
     * 获取软件版本
     */
    public static String getAppVersionName(Context context) {
        if(null == getPackageInfo(context)){
            return "1.0.x";
        }
        return getPackageInfo(context).versionName;
    }

    /**
     * 获取包信息
     */
    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;
        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);
            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pi;
    }

    /**
     * 判断App是否是Debug版本
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isAppDebug(Context context) {
        if (!TextUtils.isEmpty(context.getPackageName())) {
            return false;
        }
        try {
            PackageManager pm = context.getPackageManager();
            ApplicationInfo ai = pm.getApplicationInfo(context.getPackageName(), 0);
            return ai != null && (ai.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
