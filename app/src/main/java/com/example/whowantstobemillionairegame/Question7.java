package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question7 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"Stanley Kubrick"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA7, getAnswerB7, getAnswerC7, getAnswerD7;

    Button next_Question7;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
//Activity context from XML file
        getAnswerA7 = findViewById(R.id.answerA7);
        getAnswerB7 = findViewById(R.id.answerB7);
        getAnswerC7 = findViewById(R.id.answerC7);
        getAnswerD7 = findViewById(R.id.answerD7);
        next_Question7 = findViewById(R.id.next_question7);
        //FindViewByID to match up with Layout ID information
        getAnswerA7.setOnClickListener (this);
        getAnswerB7.setOnClickListener(this);
        getAnswerC7.setOnClickListener(this);
        getAnswerD7.setOnClickListener(this);
        next_Question7.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA7.setBackgroundColor(Color.WHITE);
        getAnswerB7.setBackgroundColor(Color.WHITE);
        getAnswerC7.setBackgroundColor(Color.WHITE);
        getAnswerD7.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question7) {
            if (selectedAnswer.equals(Question7.answers[0])) {
                Toast.makeText(Question7.this, "This is the correct answer. You win $10,000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question8.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//
            } else {
                Toast.makeText(Question7.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LosingActivity.class);
                startActivity(intent);
                //Toast message that indicates the wrong answer was selected and the user is taken to the losing activity
                //to indicate they lost the game. Else//
            }
        }else
        {
            selectedAnswer = clickedAnswer.getText().toString();
            clickedAnswer.setBackgroundColor(Color.GREEN);
        }
        //When an answer is clicked by a user, the box turns green and the rest turn white//
    }
}
