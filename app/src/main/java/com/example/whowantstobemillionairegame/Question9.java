package com.example.whowantstobemillionairegame;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.graphics.Color;



public class Question9 extends AppCompatActivity  implements View.OnClickListener
{
    static String[] answers = {"151"};
    //Static string created to identify right answer from XML file to match up with text
    Button getAnswerA9, getAnswerB9, getAnswerC9, getAnswerD9;

    Button next_Question9;

    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
//Activity context from XML file
        getAnswerA9 = findViewById(R.id.answerA9);
        getAnswerB9 = findViewById(R.id.answerB9);
        getAnswerC9 = findViewById(R.id.answerC9);
        getAnswerD9 = findViewById(R.id.answerD9);
        next_Question9 = findViewById(R.id.next_question9);
        //FindViewByID to match up with Layout ID information
        getAnswerA9.setOnClickListener (this);
        getAnswerB9.setOnClickListener(this);
        getAnswerC9.setOnClickListener(this);
        getAnswerD9.setOnClickListener(this);
        next_Question9.setOnClickListener(this);

    }
    @Override
    public void onClick(View view)
    {
        getAnswerA9.setBackgroundColor(Color.WHITE);
        getAnswerB9.setBackgroundColor(Color.WHITE);
        getAnswerC9.setBackgroundColor(Color.WHITE);
        getAnswerD9.setBackgroundColor(Color.WHITE);
//When an answer is selected, the colors of the other choices will turn into a different color
        //besides the one that has been clicked by the user//
        Button clickedAnswer = (Button) view;

        if (clickedAnswer.getId()==R.id.next_question9) {
            if (selectedAnswer.equals(Question9.answers[0])) {
                Toast.makeText(Question9.this, "This is the correct answer. You win $50,000", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Question10.class);
                startActivity(intent);
                //When an answer is selected, the colors of the other choices will turn into a different color
                //besides the one that has been clicked by the user//
            } else {
                Toast.makeText(Question9.this, "This is the wrong answer.", Toast.LENGTH_SHORT).show();
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