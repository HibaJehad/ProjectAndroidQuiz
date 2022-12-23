package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String selectedTopicNme = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout php = findViewById(R.id.phplayout);
        final LinearLayout java = findViewById(R.id.javalayout);
        final LinearLayout android = findViewById(R.id.androidlayout);
        final LinearLayout html = findViewById(R.id.htmllayout);

        final Button startBtn = findViewById(R.id.startQuizbut);
        final Button BankButton = findViewById(R.id.BankQusButt);


        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicNme = "java";
                java.setBackgroundResource(R.drawable.white_stroke);
              //  android.setBackgroundResource(R.drawable.white_stroke);
              //  php.setBackgroundResource(R.drawable.white_stroke);
              //  html.setBackgroundResource(R.drawable.white_stroke);


            }
        });
        //*****************************************************
        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicNme = "android";
                android.setBackgroundResource(R.drawable.white_stroke);
              //  java.setBackgroundResource(R.drawable.background_white);
              //  php.setBackgroundResource(R.drawable.background_white);
              //  html.setBackgroundResource(R.drawable.background_white);


            }
        });

        //*****************************************************

        php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicNme = "php";
                php.setBackgroundResource(R.drawable.white_stroke);
              //  android.setBackgroundResource(R.drawable.white_stroke);
              //  java.setBackgroundResource(R.drawable.white_stroke);
              //  html.setBackgroundResource(R.drawable.white_stroke);


            }
        });
        //****************************************************

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedTopicNme = "html";
                html.setBackgroundResource(R.drawable.white_stroke);
              //  android.setBackgroundResource(R.drawable.white_stroke);
               // php.setBackgroundResource(R.drawable.white_stroke);
              //  java.setBackgroundResource(R.drawable.white_stroke);


            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTopicNme.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please select a topic one",Toast.LENGTH_LONG).show();
                }else{

                    Intent intent = new Intent(MainActivity.this, avtivity_quiz.class);
                    intent.putExtra("SelectATopic",selectedTopicNme);
                    startActivity(intent);
                }
            }
        });

        BankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(MainActivity.this, cardView.class);
                    intent.putExtra("SelectATopic",selectedTopicNme);
                    startActivity(intent);
            }
        });

    }
}