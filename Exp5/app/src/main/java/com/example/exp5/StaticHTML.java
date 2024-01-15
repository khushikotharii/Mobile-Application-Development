package com.example.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class StaticHTML extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_html);
        WebView myWebView = (WebView) findViewById(R.id.wv2);
        String s = "<html><body><h1>Welcome to NMIMS</h1>" +
                "<p>It's a Static Web HTML Content</p>" +
                "</body></html>";
        myWebView.loadData(s,"text/html","UTF-8");

    }
}