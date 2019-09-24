package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rules extends AppCompatActivity {

    private TextView rulesStatement, rulesNote;
    private Button redirectToLevelPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        display();
    }

    public void display()
    {
        String rule = "You have to answer the questions as fast as you can " +
                "and depending upon how many right answers you have given " +
                "in particular time yours scores will be calculated. ";

        String note = "Note: Score also depends on how many questions you are attempting";

        rulesStatement = findViewById(R.id.rulesStatement);
        rulesNote = findViewById(R.id.rulesNote);
        redirectToLevelPage = findViewById(R.id.goBackToLevel);

        rulesStatement.setText(rule);
        rulesNote.setText(note);

        redirectToLevelPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Rules.this, LevelPage.class);
                startActivity(intent);
            }
        });
    }
}
