package com.xiaochj.brainelephant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Switch;

/**
 * Created by xiaochj on 2017/3/23.
 */

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener{

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    LinearLayout ll = new LinearLayout(this);
    ll.setLayoutParams(new FrameLayout.LayoutParams(-1,-1));
    setContentView(ll);
    Switch aSwitch = new Switch(this);
    ll.addView(aSwitch);
    aSwitch.setOnCheckedChangeListener(this);
  }

  @Override public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if(isChecked){
      //open the big elephant
      Intent intent = getPackageManager().getLaunchIntentForPackage("com.sankuai.xmpp");
      startActivity(intent);
    }else{

    }
  }
}
