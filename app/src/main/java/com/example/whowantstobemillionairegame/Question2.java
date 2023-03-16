package com.example.whowantstobemillionairegame;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.Toast;


public class Question2 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"2007"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA2, getAnswerB2, getAnswerC2, getAnswerD2;
    Button next_Question2;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
//Activity context from XML file
        getAnswerA2 = findViewById(R.id.answerA2);
        getAnswerB2 = findViewById(R.id.answerB2);
        getAnswerC2 = findViewById(R.id.answerC2);
        getAnswerD2 = findViewById(R.id.answerD2);
        next_Question2 = findViewById(R.id.next_question2);

//FindViewByID to match up with Layout ID information
        getAnswerA2.setOnClickListener (this);
        getAnswerB2.setOnClickListener(this);
        getAnswerC2.setOnClickListener(this);
        getAnswerD2.setOnClickListener(this);
        next_Question2.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA2.setBackgroundColor(Color.WHITE);
        getAnswerB2.setBackgroundColor(Color.WHITE);
        getAnswerC2.setBackgroundColor(Color.WHITE);
        getAnswerD2.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
        Button clickedAnswer = (Button) view;
        //Button click//

        if (clickedAnswer.getId()==R.id.next_question2) {
            if (selectedAnswer.equals(Question2.answers[0])) { //Equals function to for the established String answers//
                Toast.makeText(Question2.this, "This is the correct answer. You now have $450", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question3.class);
                startActivity(intent);
//Toast message to be displayed after the user has selected their answer, which is the correct answer//
            } else {
                Toast.makeText(Question2.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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
