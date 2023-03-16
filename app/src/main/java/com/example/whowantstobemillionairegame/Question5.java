package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question5 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"George Gershwin"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA5, getAnswerB5, getAnswerC5, getAnswerD5;

    Button next_Question5;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
//Activity context from XML file
        getAnswerA5 = findViewById(R.id.answerA5);
        getAnswerB5 = findViewById(R.id.answerB5);
        getAnswerC5 = findViewById(R.id.answerC5);
        getAnswerD5 = findViewById(R.id.answerD5);
        next_Question5 = findViewById(R.id.next_question5);
        //FindViewByID to match up with Layout ID information
        getAnswerA5.setOnClickListener (this);
        getAnswerB5.setOnClickListener(this);
        getAnswerC5.setOnClickListener(this);
        getAnswerD5.setOnClickListener(this);
        next_Question5.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA5.setBackgroundColor(Color.WHITE);
        getAnswerB5.setBackgroundColor(Color.WHITE);
        getAnswerC5.setBackgroundColor(Color.WHITE);
        getAnswerD5.setBackgroundColor(Color.WHITE);

        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question5) {
            if (selectedAnswer.equals(Question5.answers[0])) {
                Toast.makeText(Question5.this, "This is the correct answer. You now have $3500", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question6.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//

            } else {
                Toast.makeText(Question5.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
