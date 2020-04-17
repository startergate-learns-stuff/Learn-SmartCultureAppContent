package com.example.learn_smartcultureappcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {

    EditText address;
    Button action_btn;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        address = findViewById(R.id.addr_et);
        action_btn = findViewById(R.id.action_btn);
        webview = findViewById(R.id.webview);

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient());


        action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addr = address.getText().toString();

                if (!addr.startsWith("http://")) addr = "http://" + addr;

                webview.loadUrl(addr);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) webview.goBack();
        else super.onBackPressed();
    }
}
