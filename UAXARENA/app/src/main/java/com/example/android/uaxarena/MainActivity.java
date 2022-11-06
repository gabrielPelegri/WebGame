package com.example.android.uaxarena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   webView.getSettings().setJavaScriptEnabled(true);
        webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("file://index.html");

        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                return false;
            }
        });
    }
}