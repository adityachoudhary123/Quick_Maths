package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView frontText;
    private ImageView frontLogo;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        frontText = (TextView) findViewById(R.id.frontText);
        frontLogo = (ImageView) findViewById(R.id.frontLogo);

        frontPage();
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        handler.removeCallbacksAndMessages(null);

    }

    public void frontPage() {


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LevelPage.class);
                startActivity(intent);
            }
        }, 5000);

    }
}
