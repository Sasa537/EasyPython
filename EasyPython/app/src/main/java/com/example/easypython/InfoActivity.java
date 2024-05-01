package com.example.easypython;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

   // WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo_img);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //webview = findViewById(R.id.webView);
        extractFull_text();

    }

    private void extractFull_text()
    {
        Intent intent = getIntent();
        String full_text = intent.getStringExtra("full_text");
        //webview.loadData(full_text,"text/html; charset=utf-8", null);
        TextView textView = findViewById(R.id.textView);
        textView.setText(Html.fromHtml(full_text));
    }
}
