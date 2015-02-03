package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Lvl_01 extends Activity { //has to be declared in android manifest!



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl_01);

        //get score from lvl before
        final int score = getIntent().getIntExtra("score",-1);
        //set score text
        final TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(" " + score);

        //generate lvl
        final Answer correctAnswer = new Answer();
        Random randomGenerator = new Random();
        final int questNumber = randomGenerator.nextInt(1)+1;
        Toast.makeText(getApplicationContext(),"quest "+questNumber,Toast.LENGTH_SHORT);


        final TextView quest = (TextView) findViewById(R.id.txtQuest);
        //set question text
        switch(questNumber){
            case 1:
                quest.setText("click on red box!");
                correctAnswer.setAnswer(1);
                break;
            case 2:
                quest.setText("click on blue box!");
                correctAnswer.setAnswer(2);
                break;

            default:
                Toast.makeText(getApplicationContext(),"FAIL",Toast.LENGTH_SHORT);
                break;
        }
        //quest appears after 1 second
        quest.postDelayed(new Runnable() {
            @Override
            public void run() {
                quest.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(),toString(quest_01.getAlpha()),Toast.LENGTH_SHORT);
            }
        }, 1000);

        //boxes appears after 2 seconds
        //clickable options button
        final RelativeLayout optionsClickable = (RelativeLayout) findViewById(R.id.questOptionsClickable);
        //quest options
        final RelativeLayout questOpt01 = (RelativeLayout) findViewById(R.id.questOpt01);
        final RelativeLayout questOpt02 = (RelativeLayout) findViewById(R.id.questOpt02);

        optionsClickable.postDelayed(new Runnable() {
            @Override
            public void run() {
                optionsClickable.setVisibility(View.VISIBLE);
                optionsClickable.setAlpha(1);

                //set options visible
                switch (questNumber){
                    case 1: questOpt01.setVisibility(View.VISIBLE);
                            break;
                    case 2: questOpt02.setVisibility(View.VISIBLE);
                            break;

                    default:    Toast.makeText(getApplicationContext(),"FAIL",Toast.LENGTH_SHORT);
                                break;
                }
            }
        }, 2000);


        //set buttons
        Button optionClickable01 = (Button) findViewById(R.id.btnOpt01);
        Button optionClickable02 = (Button) findViewById(R.id.btnOpt02);
        Button optionClickable03 = (Button) findViewById(R.id.btnOpt03);
        Button optionClickable04 = (Button) findViewById(R.id.btnOpt04);

        //user chooses answer
        final Answer answer = new Answer();
        optionClickable01.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(1);
                goToNextLvl(answer.checkAnswer(correctAnswer), score);
            }
        });
        optionClickable02.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(2);
                goToNextLvl(answer.checkAnswer(correctAnswer), score);
            }
        });
        optionClickable03.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(3);
                goToNextLvl(answer.checkAnswer(correctAnswer), score);
            }
        });
        optionClickable04.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(4);
                goToNextLvl(answer.checkAnswer(correctAnswer), score);
            }
        });


        /**
        // correct box option
        red_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lvl_01.class);
                intent.putExtra("score", score+1);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"YOU WON!", Toast.LENGTH_LONG).show();
                scoreView.setText(" " + (score+1) );
            }

        });

        // wrong boxes options
        blue_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lvl_02.class);
                intent.putExtra("score", score-1);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"YOU WON!", Toast.LENGTH_LONG).show();
                scoreView.setText(" " + (score - 1));
            }

        });
        */



    }

    //************end of onCreate ************//

    public void goToNextLvl(boolean result, int score){
        if(result){
            Intent intent = new Intent(getApplicationContext(), Lvl_01.class);
            intent.putExtra("score", score+1);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), Lvl_01.class);
            intent.putExtra("score", score-1);
            startActivity(intent);
        }
    }

}


