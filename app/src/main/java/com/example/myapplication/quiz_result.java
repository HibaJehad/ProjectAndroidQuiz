package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class quiz_result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final TextView correctAns = findViewById(R.id.correctAnsTextV);
        final TextView wrongAns = findViewById(R.id.INcorrectAnsTextV);
        final AppCompatButton startNewButt = findViewById(R.id.startNewQuizButt);

        final int getCorrectAns = getIntent().getIntExtra("Correct", 0);
        final int getInCorrectAns = getIntent().getIntExtra("InCorrect", 0);

        correctAns.setText(String.valueOf(getCorrectAns));
        wrongAns.setText(String.valueOf(getInCorrectAns));

        startNewButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quiz_result.this, MainActivity.class));
                finish();
            }
        });

    }
    @Override
    public void onBackPressed(){

        startActivity(new Intent(quiz_result.this,MainActivity.class));
        finish();
    }
}