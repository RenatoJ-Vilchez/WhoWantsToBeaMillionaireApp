package com.example.whowantstobemillionairegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

public class LosingActivity extends AppCompatActivity
{
    Button TryAgain_BTN;
    //Button ID for Try Again as based on Layout file//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);
        //Information to correspond with Losing XML file//

        TryAgain_BTN = findViewById(R.id.TryAgain_BTN);
//FindViewByID declared to find Try Again button//
        TryAgain_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity (new Intent(LosingActivity.this, Question1.class));
                finish(); //Activity Start declared from current losing activity  to the targeted
                //activity after the user selected the button//
            }
        });
    }
}


