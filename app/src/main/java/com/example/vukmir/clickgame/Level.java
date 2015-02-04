package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class Level extends Activity{
    ClickableOptions clickableOptions;
    ViewableOptions viewableOptions;
    TopPanel topPanel;
    int loseScore;
    int winScore;
    Class nextLevel;
    List<Answer> correctAnswers = new ArrayList<>();

    public Level(int loseScore, int winScore, ClickableOptions clickableOptions, ViewableOptions viewableOptions, TopPanel topPanel, Class nextLevel, List<Answer> correctAnswers) {
        this.loseScore = loseScore;
        this.winScore = winScore;
        this.clickableOptions = clickableOptions;
        this.viewableOptions = viewableOptions;
        this.topPanel = topPanel;
        this.nextLevel = nextLevel;
        if(correctAnswers == null)
            throw new NullPointerException("correct answers null");
        else
            this.correctAnswers.addAll(correctAnswers);
    }

    public void startLvl(){

        if(gameLost()){
            goToNextLvl(MainActivity.class);
        }
        else if(lvlDone()){
            Intent nextLvl = new Intent(getApplicationContext(), nextLevel);
            nextLvl.putExtra("score",topPanel.getScore());
            startActivity(nextLvl);
        }





        clickableOptions.disappear();
        viewableOptions.disappear();
        topPanel.questionDisappear();
        final int questionNumber = topPanel.generateQuestion();
        clickableOptions.setCorrectAnswer(correctAnswers.get(questionNumber));

        //show top panel after 1 sec
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                topPanel.questionAppear();
            }
        },1000);

        //show options after 2 sec
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewableOptions.appear();
                clickableOptions.appear();

                //set clickable buttons
                clickableOptions.getOption(0).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if(correctAnswers.get(questionNumber).getAnswer() == 0){
                            topPanel.increaseScore(1);
                            startLvl();
                        }
                        else {
                            topPanel.decreaseScore(1);
                            startLvl();
                        }
                    }
                });

                clickableOptions.getOption(1).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if(correctAnswers.get(questionNumber).getAnswer() == 1){
                            topPanel.increaseScore(1);
                            startLvl();
                        }
                        else {
                            topPanel.decreaseScore(1);
                            startLvl();
                        }
                    }
                });

                clickableOptions.getOption(2).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if(correctAnswers.get(questionNumber).getAnswer() == 2){
                            topPanel.increaseScore(1);
                            startLvl();
                        }
                        else {
                            topPanel.decreaseScore(1);
                            startLvl();
                        }
                    }
                });

                clickableOptions.getOption(3).setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        if(correctAnswers.get(questionNumber).getAnswer() == 3){
                            topPanel.increaseScore(1);
                            startLvl();
                        }
                        else {
                            topPanel.decreaseScore(1);
                            startLvl();
                        }
                    }
                });

            }
        },2000);



    }

    public void goToNextLvl(Class nextLvl){
        Intent nextLevel = new Intent(getApplicationContext(),nextLvl);
        startActivity(nextLevel);
    }


    public boolean gameLost(){
        if(topPanel.getScore() < loseScore)
            return true;
        else
            return false;
    }
    public boolean lvlDone(){
        if(topPanel.getScore() > winScore)
            return true;
        else
            return false;
    }


}
