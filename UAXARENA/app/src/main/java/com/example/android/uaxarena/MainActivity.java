package com.example.android.uaxarena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView mWebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  webView.getSettings().setJavaScriptEnabled(true);
        //  webView.getSettings().setAllowFileAccess(true);
        //  webView.getSettings().setAllowContentAccess(true);
        //   mWebView.getSettings().setAllowFileAccessFromFileURLs(true);
        mWebView = (WebView) findViewById(R.id.web_view);
        mWebView.loadUrl("file:///assets/index.html");

        mWebView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }
        });
    }
}