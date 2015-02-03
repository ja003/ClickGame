package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Lvl_01 extends Activity { //has to be declared in android manifest!

    int LOW_SCORE = 0;
    int HIGH_SCORE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl_01);

        //get score from lvl before
        Score score = new Score(getIntent().getIntExtra("score",-1));
        //final int score = getIntent().getIntExtra("score",-1);


        //quest options
        final RelativeLayout questOpt01 = (RelativeLayout) findViewById(R.id.questOpt01);
        final RelativeLayout questOpt02 = (RelativeLayout) findViewById(R.id.questOpt02);

        final List<RelativeLayout> viewableOptions = new ArrayList<>();
        viewableOptions.add(questOpt01);
        viewableOptions.add(questOpt02);

        //clickable options button
        final RelativeLayout optionsClickable = (RelativeLayout) findViewById(R.id.questOptionsClickable);
        //set buttons
        Button optionClickable01 = (Button) findViewById(R.id.btnOpt01);
        Button optionClickable02 = (Button) findViewById(R.id.btnOpt02);
        Button optionClickable03 = (Button) findViewById(R.id.btnOpt03);
        Button optionClickable04 = (Button) findViewById(R.id.btnOpt04);

        final List<Button> clickableOptions = new ArrayList<>();
        clickableOptions.add(optionClickable01);
        clickableOptions.add(optionClickable02);
        clickableOptions.add(optionClickable03);
        clickableOptions.add(optionClickable04);

        startLvl(score, clickableOptions, optionsClickable, viewableOptions);





    //************end of onCreate ************//

    public void startLvl(Score score0, final List<Button> clickableOptions, final RelativeLayout optionsClickable, final List<RelativeLayout> viewableOptions){
        //set score text
        final Score score = score0;
        final TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(" " + score.getScore());

        //generate question number
        final Answer correctAnswer = new Answer();
        Random randomGenerator = new Random();
        final int questNumber = randomGenerator.nextInt(3)+1;
        Toast.makeText(getApplicationContext(),"quest "+questNumber,Toast.LENGTH_SHORT).show();

        final TextView quest = (TextView) findViewById(R.id.txtQuest);
        //set question text
        switch(questNumber){
            case 1:
                quest.setText("click on green box!");
                correctAnswer.setAnswer(1);
                break;
            case 2:
                quest.setText("click on yellow box!");
                correctAnswer.setAnswer(2);
                break;

            default:
                Toast.makeText(getApplicationContext(),"FAIL",Toast.LENGTH_SHORT).show();
                correctAnswer.setAnswer(-1);
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


        optionsClickable.postDelayed(new Runnable() {
            @Override
            public void run() {
                optionsClickable.setVisibility(View.VISIBLE);
                optionsClickable.setAlpha(1);
                //appearClickableOptions(clickableOptions);

                //set options visible
                /*
                switch (questNumber){
                    case 1:
                        questOpt01.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        questOpt02.setVisibility(View.VISIBLE);
                        break;

                    default:
                        Toast.makeText(getApplicationContext(),"FAIL",Toast.LENGTH_SHORT);
                        break;
                }
                */
                viewableOptions.get(questNumber-1).setVisibility(View.VISIBLE);
            }
        }, 2000);






        //user chooses answer
        final Answer answer = new Answer();
        clickableOptions.get(0).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(1);
                if(checkScore(score))
                    specialScore(score);
                else
                    goToNextQuest(answer.checkAnswer(correctAnswer), score, clickableOptions, viewableOptions);
            }
        });
        clickableOptions.get(1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(2);
                if(checkScore(score))
                    specialScore(score);
                else
                    goToNextQuest(answer.checkAnswer(correctAnswer), score, clickableOptions, viewableOptions);
            }
        });
        clickableOptions.get(2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(3);
                if(checkScore(score))
                    specialScore(score);
                else
                    goToNextQuest(answer.checkAnswer(correctAnswer), score, clickableOptions, viewableOptions);
            }
        });
        clickableOptions.get(3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                answer.setAnswer(4);
                if(checkScore(score))
                    specialScore(score);
                else
                    goToNextQuest(answer.checkAnswer(correctAnswer), score, clickableOptions, viewableOptions);
            }
        });
    }

    public void goToNextQuest(boolean result, Score score, RelativeLayout clickableOptions, List<RelativeLayout> viewableOptions){
        if(result){
            disappearOptions(clickableOptions, viewableOptions);
            score.increaseScore(1);
            startLvl(score);
            /*
            Intent nextQuest = new Intent(getApplicationContext(), Lvl_01.class);
            nextQuest.putExtra("score", score.getScore() + 1);
            startActivity(nextQuest);
            */
        }
        else{
            disappearOptions(clickableOptions, viewableOptions);
            score.decreaseScore(1);
            startLvl(score);
        }
    }

    public boolean checkScore(Score score){
        if(score.getScore() < LOW_SCORE){
            return true;
        }
        else if(score.getScore() > HIGH_SCORE){
            return true;
        }
        return false;
    }

    public void specialScore(Score score){
        if(score.getScore() < LOW_SCORE){
            Toast.makeText(getApplicationContext(),"YOU LOSE", Toast.LENGTH_SHORT).show();
            Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainMenu);
        }
        else if(score.getScore() > HIGH_SCORE){
            Toast.makeText(getApplicationContext(),"YOU WIN", Toast.LENGTH_SHORT).show();
        }
    }

    public void appearClickableOptions(List<Button> clickableOptions){
        for(Button b : clickableOptions){
            b.setVisibility(View.VISIBLE);
        }
    }

    public void disappearOptions(RelativeLayout optionsClickable, List<RelativeLayout> viewableOptions){
        optionsClickable.setVisibility(View.INVISIBLE);
        for(RelativeLayout r : viewableOptions){
            r.setVisibility(View.INVISIBLE);
        }
    }

}


