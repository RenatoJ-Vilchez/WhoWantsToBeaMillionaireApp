package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;



public class Question10 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"25"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA10, getAnswerB10, getAnswerC10, getAnswerD10;

    Button next_Question10;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question10);
//Activity context from XML file
        getAnswerA10 = findViewById(R.id.answerA10);
        getAnswerB10 = findViewById(R.id.answerB10);
        getAnswerC10 = findViewById(R.id.answerC10);
        getAnswerD10 = findViewById(R.id.answerD10);
        next_Question10 = findViewById(R.id.next_question10);
        //FindViewByID to match up with Layout ID information
        getAnswerA10.setOnClickListener (this);
        getAnswerB10.setOnClickListener(this);
        getAnswerC10.setOnClickListener(this);
        getAnswerD10.setOnClickListener(this);
        next_Question10.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA10.setBackgroundColor(Color.WHITE);
        getAnswerB10.setBackgroundColor(Color.WHITE);
        getAnswerC10.setBackgroundColor(Color.WHITE);
        getAnswerD10.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question10) {
            if (selectedAnswer.equals(Question10.answers[0])) {
                Toast.makeText(Question10.this, "You have done it. You won $1,000,000. Congrats", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WinningActivity.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//
            } else
            {

                Toast.makeText(Question10.this, "Wrong. You have failed", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), LosingActivity.class);
                startActivity(intent);
                //Toast message that indicates the wrong answer was selected and the user is taken to the losing activity
                //to indicate they lost the game. Else//
            }

        } else
        {
            selectedAnswer = clickedAnswer.getText().toString();
            clickedAnswer.setBackgroundColor(Color.GREEN);
        }
        //When an answer is clicked by a user, the box turns green and the rest turn white//
    }
}