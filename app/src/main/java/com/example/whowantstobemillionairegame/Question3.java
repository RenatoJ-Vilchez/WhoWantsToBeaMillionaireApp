package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question3 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"1867"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA3, getAnswerB3, getAnswerC3, getAnswerD3;
    Button next_Question3;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
//Activity context from XML file
        getAnswerA3 = findViewById(R.id.answerA3);
        getAnswerB3 = findViewById(R.id.answerB3);
        getAnswerC3 = findViewById(R.id.answerC3);
        getAnswerD3 = findViewById(R.id.answerD3);
        next_Question3 = findViewById(R.id.next_question3);
        //FindViewByID to match up with Layout ID information

        getAnswerA3.setOnClickListener (this);
        getAnswerB3.setOnClickListener(this);
        getAnswerC3.setOnClickListener(this);
        getAnswerD3.setOnClickListener(this);
        next_Question3.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA3.setBackgroundColor(Color.WHITE);
        getAnswerB3.setBackgroundColor(Color.WHITE);
        getAnswerC3.setBackgroundColor(Color.WHITE);
        getAnswerD3.setBackgroundColor(Color.WHITE);
        //When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//

        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question3) {
            if (selectedAnswer.equals(Question3.answers[0])) {
                Toast.makeText(Question3.this, "This is the correct answer. You now have $1000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question4.class);
                startActivity(intent);
//Toast message to be displayed after the user has selected their answer, which is the correct answer//

            } else {
                Toast.makeText(Question3.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
