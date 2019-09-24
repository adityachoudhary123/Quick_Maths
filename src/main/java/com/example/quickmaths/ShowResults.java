package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import Logic.CalculateScore;
import Logic.CalculateScoreImpl;

public class ShowResults extends AppCompatActivity {


    private TextView totalQuestionDisp, rightAnswer, wrongAnswer, scoreDisp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results);
        display();
    }
    public void onBackPressed()
    {
        super.onBackPressed();
        System.exit(0);
    }

    public void display() {
        totalQuestionDisp = findViewById(R.id.totalQuestion);
        rightAnswer = findViewById(R.id.right);
        wrongAnswer = findViewById(R.id.wrong);
        scoreDisp = findViewById(R.id.score);
        getValues();
    }

    public void getValues()
    {
        Intent intent = getIntent();
        int countR = intent.getIntExtra("countR",0);
        int countW = intent.getIntExtra("countW", 0);

        CalculateScoreImpl calculateScore = new CalculateScore();
        int score = calculateScore.calculateScore(countR,countW);
        showResults(countR,countW,score);
    }

    public void showResults(int countR, int countW, int score)
    {
        int totalQuestion = countR + countW;
        String scoreResult = Integer.toString(score) + "%";
        totalQuestionDisp.setText(Integer.toString(totalQuestion));
        rightAnswer.setText(Integer.toString(countR));
        wrongAnswer.setText(Integer.toString(countW));
        scoreDisp.setText(scoreResult);
    }


}
