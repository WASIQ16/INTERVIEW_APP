package com.example.interview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Tough extends AppCompatActivity implements View.OnClickListener {
    TextView questions, answers, total_length_yy, present_index_xx;
    Button show;
    ImageButton next, previous;
    String[] Question, answr;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tough);

        ConstraintLayout constraintLayout =findViewById(R.id.toughlauout);
        AnimationDrawable animationDrawable= (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();


        questions = (TextView) findViewById(R.id.question);
        answers = (TextView) findViewById(R.id.answer);
        total_length_yy = (TextView) findViewById(R.id.txtyy);
        present_index_xx = (TextView) findViewById(R.id.txtxx);

        next = (ImageButton) findViewById(R.id.nexts);
        next.setOnClickListener(this);
        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);
        previous = (ImageButton) findViewById(R.id.prevs);
        previous.setOnClickListener(this);

        Question = getResources().getStringArray(R.array.Question);
        answr = getResources().getStringArray(R.array.answr);

        index = 0;
        questions.setText(String.valueOf("Q)") + Question[0]);
        answers.setText("Press \"Answer\" Button for the answer.");
        present_index_xx.setText(String.valueOf(index + 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.prevs:
                if(index < 0)
                {
                    Toast.makeText(getApplicationContext(),"No question availible.",Toast.LENGTH_SHORT).show();
                }
                else if (index == 20) {
                    Toast.makeText(getApplicationContext(),"No question availible MAIN MENU .",Toast.LENGTH_SHORT).show();
                    Intent main=new Intent(Tough.this,Main_menu.class);
                }
                else
                {
                    answers.setText("Press \"Answer\" Button for the answer.");
                    index--;
                    questions.setText(String.valueOf("Q)")+Question[index]);
                    present_index_xx.setText(String.valueOf(index+1));
                }
                break;

            case R.id.nexts:
                if(index > Question.length)
                {
                    Toast.makeText(getApplicationContext(),"Question Completed.",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    answers.setText("Press \"Answer\" Button for the answer.");
                    index++;
                    questions.setText(String.valueOf("Q)")+Question[index]);
                    present_index_xx.setText(String.valueOf(index+1));
                }
                break;

            case R.id.show:
                answers.setText(String.valueOf("Ans)")+answr[index]);
                break;
        }

    }
}