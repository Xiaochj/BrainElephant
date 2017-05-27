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
        openTheTruth(getString(R.string.first_text),getString(R.string.radio_name));
      }else if(eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED){
        //打开工作台
        openTheTruth(getString(R.string.second_text),"aa");
      }
    }
  }

  private void openTheTruth(String text,String className) {
    List<AccessibilityNodeInfo>
        nodeInfos = getRootInActiveWindow().findAccessibilityNodeInfosByText(text);
    int size = nodeInfos.size();
    if (size == 0)
      return;
    if (size >= 1) {
      int temp = 0;
      while (temp < size){
        if(nodeInfos.get(temp).getClassName().equals(className)){
          nodeInfos.get(temp).performAction(AccessibilityNodeInfo.ACTION_CLICK);
          break;
        }
        temp++;
      }
      return;
    }
  }

  @Override public void onInterrupt() {

  }
}
