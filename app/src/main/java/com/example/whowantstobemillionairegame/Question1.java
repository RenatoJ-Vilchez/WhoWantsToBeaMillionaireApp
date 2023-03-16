package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;

public class Question1 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"Thomas Jefferson"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA1, getAnswerB1, getAnswerC1, getAnswerD1;
    Button next_Question;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
//Activity context from XML file
        getAnswerA1 = findViewById(R.id.answerA1);
        getAnswerB1 = findViewById(R.id.answerB1);
        getAnswerC1 = findViewById(R.id.answerC1);
        getAnswerD1 = findViewById(R.id.answerD1);
        next_Question = findViewById(R.id.next_question);
//FindViewByID to match up with Layout ID information
        getAnswerA1.setOnClickListener(this);
        getAnswerB1.setOnClickListener(this);
        getAnswerC1.setOnClickListener(this);
        getAnswerD1.setOnClickListener(this);
        next_Question.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
    getAnswerA1.setBackgroundColor(Color.WHITE);
    getAnswerB1.setBackgroundColor(Color.WHITE);
    getAnswerC1.setBackgroundColor(Color.WHITE);
    getAnswerD1.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
    Button clickedAnswer = (Button) view;
    //Button click//

    if (clickedAnswer.getId()==R.id.next_question) {
        if (selectedAnswer.equals(Question1.answers[0])) { //Equals function to for the established String answers//
            Toast.makeText(Question1.this, "This is the correct answer. You now have $150", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), Question2.class);
            startActivity(intent);
//Toast message to be displayed after the user has selected their answer, which is the correct answer!!
        } else
        {

            Toast.makeText(Question1.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
