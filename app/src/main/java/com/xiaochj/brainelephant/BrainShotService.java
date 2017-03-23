package com.xiaochj.brainelephant;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;

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

  }

  @Override public void onInterrupt() {

  }
}
