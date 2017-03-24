package com.xiaochj.brainelephant;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/**
 * Created by xiaochj on 2017/3/23.
 */

public class BrainShotService extends AccessibilityService {

  public BrainShotService() {
    super();
  }

  @Override protected void onServiceConnected() {
    super.onServiceConnected();
  }

  @Override public void onAccessibilityEvent(AccessibilityEvent event) {
    int eventType = event.getEventType();
    String pkgName = event.getPackageName().toString();
    if(pkgName.equalsIgnoreCase(getString(R.string.pkgname))){
      if(eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED){
        //打开客户端
        List<AccessibilityNodeInfo> nodeInfos = getRootInActiveWindow().findAccessibilityNodeInfosByText(getString(R.string.first_text));
        int size = nodeInfos.size();
        if (size == 0)
          return;
        if (size == 1) {
          nodeInfos.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
          return;
        }
      }else if(eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED){
        Utils.LogUtil("d","aaa","content");
      }
    }
  }

  @Override public void onInterrupt() {

  }
}
