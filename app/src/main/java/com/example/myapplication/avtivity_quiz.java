package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class avtivity_quiz extends AppCompatActivity {

    private AppCompatButton option1,option2,option3,option4;
    private AppCompatButton nextButt;
    private int TotalTimeMin = 1;
    private int TimeSecond = 0;
    private Timer timerQuiz;
    private int positionQustion =0;
    private String selectedOptionbyUser = "";
    private List<qustion_list>  qustionlist;
    private TextView Quests; //Qustines all
    private  TextView Quest; //Qustine

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final TextView selectTopicName = findViewById(R.id.selecttopicName);
        final ImageView backButt = findViewById(R.id.backButton);
        final TextView timer = findViewById(R.id.Timer);

        Quests = findViewById(R.id.qustionNum);///
        Quest = findViewById(R.id.qusetion);
        option1 = findViewById(R.id.option11);
        option2 = findViewById(R.id.option22);
        option3 = findViewById(R.id.option33);
        option4 = findViewById(R.id.option44);
        nextButt = findViewById(R.id.nextButton);



        final String getSelectATopic = getIntent().getStringExtra("SelectATopic");

        selectTopicName.setText(getSelectATopic);

        qustionlist =  BankQustions.getQust(getSelectATopic);


        startOfTimer(timer);

        Quests.setText((positionQustion+1)+"/"+qustionlist.size());
        Quest.setText(qustionlist.get(0).getQustion());
        option1.setText(qustionlist.get(0).getOption1());
        option2.setText(qustionlist.get(0).getOption2());
        option3.setText(qustionlist.get(0).getOption3());
        option4.setText(qustionlist.get(0).getOption4());


        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionbyUser.isEmpty()){

                    selectedOptionbyUser = option1.getText().toString();
                    option1.setBackgroundResource(R.drawable.color_red);
                    option1.setTextColor(Color.WHITE);

                    RevialAns();
                    qustionlist.get(positionQustion).setUserSelectedAnswer(selectedOptionbyUser);


                }
            }
        });


        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionbyUser.isEmpty()){

                    selectedOptionbyUser = option2.getText().toString();
                    option2.setBackgroundResource(R.drawable.color_red);
                    option2.setTextColor(Color.WHITE);

                    RevialAns();
                    qustionlist.get(positionQustion).setUserSelectedAnswer(selectedOptionbyUser);


                }

            }
        });


        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionbyUser.isEmpty()){

                    selectedOptionbyUser = option3.getText().toString();
                    option3.setBackgroundResource(R.drawable.color_red);
                    option3.setTextColor(Color.WHITE);

                    RevialAns();
                    qustionlist.get(positionQustion).setUserSelectedAnswer(selectedOptionbyUser);

                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionbyUser.isEmpty()){

                    selectedOptionbyUser = option4.getText().toString();
                    option4.setBackgroundResource(R.drawable.color_red);
                    option4.setTextColor(Color.WHITE);

                    RevialAns();
                    qustionlist.get(positionQustion).setUserSelectedAnswer(selectedOptionbyUser);


                }

            }
        });


        nextButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(selectedOptionbyUser.isEmpty()){

                    Toast.makeText(avtivity_quiz.this,"Please selecte an option",Toast.LENGTH_LONG).show();

                }else {
                    ChangeNextQust();
                }

            }
        });


        backButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                timerQuiz.purge();
                timerQuiz.cancel();

                startActivity(new Intent(avtivity_quiz.this, MainActivity.class));
                finish();
            }
        });
    }

    private void startOfTimer(TextView timetTeV){

        timerQuiz = new Timer();

        timerQuiz.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (TimeSecond == 0) {
                    TotalTimeMin--;
                    TimeSecond = 59;
                } else if (TotalTimeMin == 0 && TimeSecond == 0) {
                    timerQuiz.purge();
                    timerQuiz.cancel();

                    Toast.makeText(avtivity_quiz.this, "Time Over", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(avtivity_quiz.this, quiz_result.class);
                    intent.putExtra("Correct", getCorrectAnsw());
                    intent.putExtra("InCorrect", getInCorrectAnsw());
                    startActivity(intent);

                    finish();

                } else {
                    TimeSecond--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMint = String.valueOf(TotalTimeMin);
                        String finalSec = String.valueOf(TimeSecond);

                        if(finalMint.length() == 1){
                            finalMint = "0"+finalMint;
                        }

                        if(finalSec.length() == 1){
                            finalSec = "0"+finalSec;
                        }
                        timetTeV.setText(finalMint+":"+finalSec);

                    }
                });
            }
        },1000, 1000);

    }

    private int getCorrectAnsw(){

         int CorrectAnswer = 0;

         for (int i=0; i<qustionlist.size();i++){

             final String getUselectAns = qustionlist.get(i).getUserSelectedAnswer();
             final String getAns = qustionlist.get(i).getAnswer();

             if(getUselectAns.equals(getAns)){
                 CorrectAnswer++;
             }
         }

         return CorrectAnswer;
    }

    private int getInCorrectAnsw(){

        int InCorrectAnswer = 0;

        for (int i=0; i<qustionlist.size();i++){

            final String getUselectAns = qustionlist.get(i).getUserSelectedAnswer();
            final String getAns = qustionlist.get(i).getAnswer();

            if(getUselectAns.equals(getAns)){
                InCorrectAnswer++;
            }
        }

        return InCorrectAnswer;
    }

    @Override
   public void onBackPressed(){

        timerQuiz.purge();
        timerQuiz.cancel();

        startActivity(new Intent(avtivity_quiz.this, MainActivity.class));
        finish();

   }

   private void ChangeNextQust(){

        positionQustion++;
        if((positionQustion+1) == qustionlist.size()){

            nextButt.setText("Submite Quiz");
        }

        if(positionQustion < qustionlist.size()){

            selectedOptionbyUser = " ";
            option1.setBackgroundResource(R.drawable.white_stroke);
            option1.setTextColor(Color.parseColor("#1F6BBB"));

            option2.setBackgroundResource(R.drawable.white_stroke);
            option2.setTextColor(Color.parseColor("#1F6BBB"));

            option3.setBackgroundResource(R.drawable.white_stroke);
            option3.setTextColor(Color.parseColor("#1F6BBB"));

            option4.setBackgroundResource(R.drawable.white_stroke);
            option4.setTextColor(Color.parseColor("#1F6BBB"));

            Quests.setText((positionQustion+1)+"/"+qustionlist.size());
            Quest.setText(qustionlist.get(positionQustion).getQustion());
            option1.setText(qustionlist.get(positionQustion).getOption1());
            option2.setText(qustionlist.get(positionQustion).getOption2());
            option3.setText(qustionlist.get(positionQustion).getOption3());
            option4.setText(qustionlist.get(positionQustion).getOption4());
        }
        else{

            Intent intent = new Intent(avtivity_quiz.this,quiz_result.class);
            intent.putExtra("Correct",getCorrectAnsw());
            intent.putExtra("InCorrect",getInCorrectAnsw());

            startActivity(intent);

            finish();

        }

   }

   private void RevialAns(){

         final String getAnswQ = qustionlist.get(positionQustion).getAnswer();

        if(option1.getText().toString().equals(getAnswQ)){

            option1.setBackgroundResource(R.drawable.green_color);
            option1.setTextColor(Color.WHITE);

        }else if(option2.getText().toString().equals(getAnswQ)){

            option2.setBackgroundResource(R.drawable.green_color);
            option2.setTextColor(Color.WHITE);

        }else if(option3.getText().toString().equals(getAnswQ)){

            option3.setBackgroundResource(R.drawable.green_color);
            option3.setTextColor(Color.WHITE);

        }else if(option2.getText().toString().equals(getAnswQ)){

            option4.setBackgroundResource(R.drawable.green_color);
            option4.setTextColor(Color.WHITE);

        }



    }
}