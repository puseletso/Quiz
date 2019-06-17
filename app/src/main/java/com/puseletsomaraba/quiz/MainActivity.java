package com.puseletsomaraba.quiz;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.puseletsomaraba.quiz.model.TrueFalse;

public class MainActivity extends AppCompatActivity {
//declare constats
    //final int INCREMENT_PROGRESS_BAR=0;

    //declare variables
    ProgressBar mProgressBar;
    Button true_button, false_button;
    TextView mTextView,mScore,questionTextView;
    int score;
     int index;
    private TrueFalse mQuestion[];
    int question;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            score=savedInstanceState.getInt("scoreKey");
            index=savedInstanceState.getInt("indexKey");

        }else{
            score=0;
            index=0;

        }




        init();
        questionsArr();
        buttonLisner();
        updateQuestion();








    }


    public void buttonLisner() {



        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "PRESSED TRUE BUTTON", Toast.LENGTH_SHORT).show();

                checkAnswer(true);
                updateQuestion();
            }
        });

        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "FALSE BUTTON PRESSED", Toast.LENGTH_LONG).show();
               checkAnswer(false);
                updateQuestion();

            }
        });
    }


    void init() {
        true_button = findViewById(R.id.true_button);
        false_button = findViewById(R.id.false_button);
        mTextView=findViewById(R.id.question_text_view);
        mScore=findViewById(R.id.score);
        mProgressBar=findViewById(R.id.progress_bar);
        questionTextView=findViewById(R.id.questionidTextView);
    }

    public void questionsArr() {
        mQuestion = new TrueFalse[]{
                new TrueFalse(R.string.question_1, true)
                , new TrueFalse(R.string.question_2, true)
                , new TrueFalse(R.string.question_3, true)
                , new TrueFalse(R.string.question_4, true)
                , new TrueFalse(R.string.question_5, true)
                , new TrueFalse(R.string.question_6, false)
                , new TrueFalse(R.string.question_7, true)
                , new TrueFalse(R.string.question_8, false)
                , new TrueFalse(R.string.question_9, true)
                , new TrueFalse(R.string.question_10, true)
                , new TrueFalse(R.string.question_11, false)
                , new TrueFalse(R.string.question_12, false)
                , new TrueFalse(R.string.question_13, true)
        };


    }


    private void updateQuestion()
    {

        index=(index+1)%mQuestion.length;
        if(index==0)
        {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Game Over");
            alertDialog.setCancelable(false);
            alertDialog.setMessage("Your points :"+score+"/"+mQuestion.length);
            alertDialog.setPositiveButton("Close Quiz", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });


                    alertDialog.show();
        }
        question=mQuestion[index].getQuestion();

        mTextView.setText(question);
        mScore.setText("Score "+score+"/"+mQuestion.length);
        questionTextView.setText("Question "+index+"/"+mQuestion.length);

        //declare constats
        final int INCREMENT_PROGRESS_BAR=(int)Math.ceil(100.0/mQuestion.length);
        mProgressBar.incrementProgressBy(INCREMENT_PROGRESS_BAR);
    }

    private void checkAnswer(boolean useranswer)
    {
        boolean correctAnswer=mQuestion[index].isAnswer();

        if(useranswer==correctAnswer)
        {
            score++;
          Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey",score);
        outState.putInt("indexKey",index);
    }

}
