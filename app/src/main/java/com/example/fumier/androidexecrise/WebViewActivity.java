package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebViewActivity extends Activity implements View.OnClickListener {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings=myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(this),"CQAndroid");
        //在局域中进行测试
        myWebView.loadUrl("http://sh.meituan.com/shop/42197026?mtt=1.deal%2Fdefault.0.0.io0v6u5w");
        myWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url);
                return false;
            }
        });
    }

    //按返回键时返回上一页（有上一页的话），而不是退出程序。
    public boolean onKeyDown(int keyCode,KeyEvent event){
       if((keyCode==KeyEvent.KEYCODE_BACK)&&myWebView.canGoBack()){
           myWebView.goBack();
           return true;
       }
        return super.onKeyDown(keyCode,event);
    }


    @Override
    public void onClick(View v) {

    }
}
