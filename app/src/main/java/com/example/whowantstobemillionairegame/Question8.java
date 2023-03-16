package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;



public class Question8 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"Turin"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA8, getAnswerB8, getAnswerC8, getAnswerD8;

    Button next_Question8;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);
//Activity context from XML file
        getAnswerA8 = findViewById(R.id.answerA8);
        getAnswerB8 = findViewById(R.id.answerB8);
        getAnswerC8 = findViewById(R.id.answerC8);
        getAnswerD8 = findViewById(R.id.answerD8);
        next_Question8 = findViewById(R.id.next_question8);
        //FindViewByID to match up with Layout ID information
        getAnswerA8.setOnClickListener (this);
        getAnswerB8.setOnClickListener(this);
        getAnswerC8.setOnClickListener(this);
        getAnswerD8.setOnClickListener(this);
        next_Question8.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA8.setBackgroundColor(Color.WHITE);
        getAnswerB8.setBackgroundColor(Color.WHITE);
        getAnswerC8.setBackgroundColor(Color.WHITE);
        getAnswerD8.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question8) {
            if (selectedAnswer.equals(Question8.answers[0])) {
                Toast.makeText(Question8.this, "This is the correct answer. You win $25,000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question9.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//
            } else {
                Toast.makeText(Question8.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
