package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question4 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"Cheyenne"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA4, getAnswerB4, getAnswerC4, getAnswerD4;

    Button next_Question4;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
//Activity context from XML file
        getAnswerA4 = findViewById(R.id.answerA4);
        getAnswerB4 = findViewById(R.id.answerB4);
        getAnswerC4 = findViewById(R.id.answerC4);
        getAnswerD4 = findViewById(R.id.answerD4);
        next_Question4 = findViewById(R.id.next_question4);
        //FindViewByID to match up with Layout ID information
        getAnswerA4.setOnClickListener (this);
        getAnswerB4.setOnClickListener(this);
        getAnswerC4.setOnClickListener(this);
        getAnswerD4.setOnClickListener(this);
        next_Question4.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA4.setBackgroundColor(Color.WHITE);
        getAnswerB4.setBackgroundColor(Color.WHITE);
        getAnswerC4.setBackgroundColor(Color.WHITE);
        getAnswerD4.setBackgroundColor(Color.WHITE);
        //When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//

        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question4) {
            if (selectedAnswer.equals(Question4.answers[0])) {
                Toast.makeText(Question4.this, "This is the correct answer. You now have $2000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question5.class);
                startActivity(intent);
//Toast message to be displayed after the user has selected their answer, which is the correct answer//
            } else {
                Toast.makeText(Question4.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
