package com.example.quickmaths;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import Controller.QuestionAnswerController;
import Model.Level;
import Model.Options;
import Model.Question;

public class PlayDisplay extends AppCompatActivity {

    private String userAnswer;
    private static int countR = 0, countW = 0;
    private TextView dispNumbOne, dispNumbTwo, dispOperator,timer;
    private Button optOne, optTwo, optThree;
    private CountDownTimer countDownTimer = null;
    private Handler handler = new Handler();
    QuestionAnswerController controller = new QuestionAnswerController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_display);
        startCountDown();
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        countDownTimer.cancel();
        finish();
    }
    public void startCountDown()
    {
        countDownTimer = new CountDownTimer (60000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                finish();
                Intent intent = new Intent(PlayDisplay.this, ShowResults.class);
                Bundle extra = new Bundle();
                extra.putInt("countR",countR);
                extra.putInt("countW",countW);
                intent.putExtras(extra);
                startActivity(intent);


            }
        }.start();

        display();
    }

    public void display() {

        dispNumbOne =  findViewById(R.id.dispNumbOne);
        dispNumbTwo = findViewById(R.id.dispNumbTwo);
        dispOperator = findViewById(R.id.dispOperator);
        timer = findViewById(R.id.timer);
        optOne = findViewById(R.id.optOne);
        optTwo = findViewById(R.id.optTwo);
        optThree = findViewById(R.id.optThree);
        displayQuestions();
    }

    public void displayQuestions()
    {
        String level = Level.getLevel();

        Question question = controller.getQuestionForDisplay(level);

        optOne.setBackgroundColor(Color.parseColor("#C0C0C0"));
        optTwo.setBackgroundColor(Color.parseColor("#C0C0C0"));
        optThree.setBackgroundColor(Color.parseColor("#C0C0C0"));

        String questionDisp1 = Integer.toString(question.getNumbDispOne());
        String questionDisp2 = Integer.toString(question.getNumbDispTwo());
        String operator = question.getOperator();
        dispNumbOne.setText(questionDisp1);
        dispNumbTwo.setText(questionDisp2);
        dispOperator.setText(operator);
        displayOptions();
    }

    public void displayOptions()
    {
        Options options = controller.getOptionsForDisplay();

        String opt1 = Integer.toString(options.getOptOne());
        String opt2 = Integer.toString(options.getOptTwo());
        String opt3 = Integer.toString(options.getOptThree());
        optOne.setText(opt1);
        optTwo.setText(opt2);
        optThree.setText(opt3);
        getUserInput();
    }

    public void getUserInput()
    {
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId())
                {
                    case R.id.optOne:
                        userAnswer = optOne.getText().toString();
                        checkAnswer(optOne);
                        break;
                    case R.id.optTwo:
                        userAnswer = optTwo.getText().toString();
                        checkAnswer(optTwo);
                        break;
                    case R.id.optThree:
                        userAnswer = optThree.getText().toString();
                        checkAnswer(optThree);
                        break;
                    default:
                        break;

                }
            }
        };

        optOne.setOnClickListener(onClickListener);
        optTwo.setOnClickListener(onClickListener);
        optThree.setOnClickListener(onClickListener);

    }

    public void checkAnswer(Button opt)
    {
        if(controller.getAnswerForCheck(userAnswer))
        {
            opt.setBackgroundColor(Color.GREEN);
            countR++;
        }
        else
        {
            countW++;
            opt.setBackgroundColor(Color.RED);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                displayQuestions();
            }
        }, 200);

    }


}
