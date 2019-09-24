package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Model.Level;

public class LevelPage extends AppCompatActivity {


    private Button btnEasy, btnModerate, btnHard, btnExpert, rules;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_page);
        display();
    }

    public void display() {
        btnEasy = findViewById(R.id.btnEasy);
        btnModerate = findViewById(R.id.btnModerate);
        btnHard = findViewById(R.id.btnHard);
        btnExpert = findViewById(R.id.btnExpert);
        rules = findViewById(R.id.rules);

        getLevelFromUser();
    }

    public void getLevelFromUser() {

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String level = "";
                switch(view.getId())
                {
                    case R.id.btnEasy:
                        level = btnEasy.getText().toString();
                        goToCountDownPage(level);
                        break;
                    case R.id.btnModerate:
                        level = btnModerate.getText().toString();
                        goToCountDownPage(level);
                        break;
                    case R.id.btnHard:
                        level = btnHard.getText().toString();
                        goToCountDownPage(level);
                        break;
                    case R.id.btnExpert:
                        level = btnExpert.getText().toString();
                        goToCountDownPage(level);
                        break;
                    case R.id.rules:
                        Intent intent = new Intent(LevelPage.this, Rules.class);
                        startActivity(intent);
                        break;

                }



            }
        };

        btnEasy.setOnClickListener(onClickListener);
        btnModerate.setOnClickListener(onClickListener);
        btnHard.setOnClickListener(onClickListener);
        btnExpert.setOnClickListener(onClickListener);
        rules.setOnClickListener(onClickListener);
    }

    public void goToCountDownPage(String level)
    {
        Level.setLevel(level);
        Intent intent = new Intent(LevelPage.this, CountdownPage.class);
        startActivity(intent);
    }

}

