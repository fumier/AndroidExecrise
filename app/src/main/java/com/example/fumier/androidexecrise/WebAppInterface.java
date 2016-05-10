package com.example.fumier.androidexecrise;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by fumier on 2016/5/9.
 */
public class WebAppInterface {
    Context mContext;

    WebAppInterface(Context c){
        mContext=c;
    }

    @JavascriptInterface
    public void showToast(String toast){
        Toast.makeText(mContext,toast,Toast.LENGTH_LONG).show();;
    }

}
