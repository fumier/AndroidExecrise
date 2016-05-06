package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


public class ShareDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        windowDeploy();
    }

   public static void startShare(Context context){
        Intent intent=new Intent(context,ShareDialogActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    public void windowDeploy() {
        Window window = getWindow();
        window.setWindowAnimations(R.style.push_bottom);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.x = 0;
        wl.y = 0;
        wl.width = ViewGroup.LayoutParams.MATCH_PARENT;
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        wl.gravity = Gravity.BOTTOM;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        //设置背景的暗度，0.0f至1.0f,1.0f全暗
        final float dimAmount = 0.6f;
        wl.dimAmount = dimAmount;
        window.setAttributes(wl);
    }
}
