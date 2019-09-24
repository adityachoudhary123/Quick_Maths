package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CountdownPage extends AppCompatActivity {


    private TextView countdown;
    private Button btnStartCountdown;
    private CountDownTimer countDownTimer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_page);
        display();
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        finish();
    }

    public void display() {
        btnStartCountdown = findViewById(R.id.btnCountdown);
        countdown = findViewById(R.id.countdown);
        btnStartCountdown.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                btnStartCountdown.setVisibility(View.INVISIBLE);
                countdown.setVisibility(View.VISIBLE);
                countDownTimer = new CountDownTimer(4000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        countdown.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        countdown.setText("GO!!");
                        goToPlayPage();

                    }
                }.start();
            }
        });
    }

    public void goToPlayPage()
    {
        finish();
        Intent intent = new Intent(CountdownPage.this, PlayDisplay.class);
        startActivity(intent);
    }
}
