package com.xiaochj.brainelephant;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xiaochj on 16/11/5.
 */

public class Utils {

  /**
   * log日志
   */
  public static void LogUtil(String logType, String tag, String str) {
    if (logType.equalsIgnoreCase("v")) {

    } else if (logType.equalsIgnoreCase("d")) {
      Log.d(tag, str);
    } else if (logType.equalsIgnoreCase("e")) {

    } else if (logType.equalsIgnoreCase("i")) {

    }
  }

  /**
   * toast提示
   */
  public static void ToastUtil(Context ctx, String text) {
    Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();
  }

  /**
   * 判断某个服务是否开启
   */
  public static boolean isAccessibilitySettingsOn(Context ctx, String service) {
    int accessibilityEnabled = 0;
    //        final String service = "com.test.package.name/com.test.package.name.YOURAccessibilityService";
    boolean accessibilityFound = false;
    try {
      accessibilityEnabled =
          Settings.Secure.getInt(ctx.getApplicationContext().getContentResolver(),
              android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
    } catch (Exception e) {

    }
    TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');

    if (accessibilityEnabled == 1) {
      String settingValue =
          Settings.Secure.getString(ctx.getApplicationContext().getContentResolver(),
              Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
      if (settingValue != null) {
        TextUtils.SimpleStringSplitter splitter = mStringColonSplitter;
        splitter.setString(settingValue);
        while (splitter.hasNext()) {
          String accessabilityService = splitter.next();

          if (accessabilityService.equalsIgnoreCase(service)) {
            return true;
          }
        }
      }
    } else {
    }

    return accessibilityFound;
  }
}
