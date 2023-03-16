package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question6 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"White House"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA6, getAnswerB6, getAnswerC6, getAnswerD6;

    Button next_Question6;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
//Activity context from XML file
        getAnswerA6 = findViewById(R.id.answerA6);
        getAnswerB6 = findViewById(R.id.answerB6);
        getAnswerC6 = findViewById(R.id.answerC6);
        getAnswerD6 = findViewById(R.id.answerD6);
        next_Question6 = findViewById(R.id.next_question6);
        //FindViewByID to match up with Layout ID information
        getAnswerA6.setOnClickListener (this);
        getAnswerB6.setOnClickListener(this);
        getAnswerC6.setOnClickListener(this);
        getAnswerD6.setOnClickListener(this);
        next_Question6.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA6.setBackgroundColor(Color.WHITE);
        getAnswerB6.setBackgroundColor(Color.WHITE);
        getAnswerC6.setBackgroundColor(Color.WHITE);
        getAnswerD6.setBackgroundColor(Color.WHITE);

        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question6) {
            if (selectedAnswer.equals(Question6.answers[0])) {
                Toast.makeText(Question6.this, "This is the correct answer. You win $5000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question7.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//

            } else {
                Toast.makeText(Question6.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
