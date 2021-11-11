package com.example.demorecyclerview.Actitivies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.demorecyclerview.R;

public class WebsiteActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        webView = findViewById(R.id.webView);
        webView.loadUrl("https://www.fahasa.com/ngay-dac-biet-dai-tiec-sale?campaignid=1680365247&adgroupid=66862302393&utm_source=google&utm_medium=cpc&utm_campaign=TQ_GSN_Generic_na_na_na_na_na_CPC&gclid=Cj0KCQiA-K2MBhC-ARIsAMtLKRtZtbucktTu-D_ZWFI4sbnx7gLHNjlxAReTUPaR1uebT79LH7z1IA4aAoA4EALw_wcB&attempt=1");
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}