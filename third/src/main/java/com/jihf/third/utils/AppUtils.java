package com.jihf.third.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Date：2017-04-20 15:40
 * Mail：jihaifeng@raiyi.com
 */
public class AppUtils {
  public static AppUtils instance;
  public static Context mContext;
  public static final String QQ_PKGNAME = "com.tencent.mobileqq";
  public static final String WX_PKGNAME = "com.tencent.mm";

  public static AppUtils getInstance(Context context) {
    mContext = context;
    if (null == instance) {
      synchronized (AppUtils.class) {
        if (null == instance) {
          instance = new AppUtils();
        }
      }
    }
    return instance;
  }

  public boolean isAppAvilible(String pkgName) {
    final PackageManager packageManager = mContext.getPackageManager();// 获取packagemanager
    List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
    if (pinfo != null) {
      for (int i = 0; i < pinfo.size(); i++) {
        String pn = pinfo.get(i).packageName;
        if (pn.equals("com.tencent.mm")) {
          return true;
        }
      }
    }

    return false;
  }
}
