package com.example.fumier.androidexecrise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


public class WebViewProgressBarActivity extends Activity {

    private WebView webView;
    private ProgressBar progressBar;
    protected static final String WEB_SITE ="http://sh.meituan.com/shop/42197026?mtt=1.deal%2Fdefault.0.0.io0v6u5w";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_activity_progressbar);
        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        final WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        final String url = "http://sh.meituan.com/shop/42197026?mtt=1.deal%2Fdefault.0.0.io0v6u5w";
//        final String url="http://baidu.com";
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.loadUrl(url);
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            super.shouldOverrideUrlLoading(view, url);
            if (url.equals(WEB_SITE)) {
//                // internal site link, let webview handle it
                return false;
            } else {
                // external site link, let system handle it
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
               return true;//return true的时候，浏览器会打开链接，然后自己的WebView不做任何处理；如果是false的话，浏览器打开链接，自己的WebView也会显示网页的内容
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (progressBar != null) {
                progressBar.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (progressBar != null) {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    private class MyWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            final int completeProgress = 100;
            if (newProgress == completeProgress) {
                if (progressBar != null) {
                    progressBar.setVisibility(View.GONE);
                    return;
                }
            }
            if (progressBar != null) {
                progressBar.setProgress(newProgress);
            }
        }
    }
}
