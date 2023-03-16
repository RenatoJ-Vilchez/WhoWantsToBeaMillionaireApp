package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class WinningActivity extends AppCompatActivity
{
    Button PlayAgain_BTN;
//PlayAgain Button ID to be connected from Winning Layout file//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);
        //Information to correspond with Winning XML file//

        PlayAgain_BTN = findViewById(R.id.PlayAgain_BTN);
//FindViewByID declared to find button//
        PlayAgain_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(WinningActivity.this, Question1.class));
                finish(); //Activity Start declared from current activity of Winning Activity to the targeted
                //activity after the user selected the button//
            }
        });
    }
}


