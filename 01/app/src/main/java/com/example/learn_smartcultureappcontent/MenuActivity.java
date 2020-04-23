package com.example.learn_smartcultureappcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void goToWebView(View v) {
        Intent intent = new Intent(this, WebViewActivity.class);
        startActivity(intent);
    }

    public void goToListView(View v) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    public void goToGridView(View v) {
        Intent intent = new Intent(this, GridViewActivity.class);
        startActivity(intent);
    }
}
