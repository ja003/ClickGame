package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;

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
            Intent mainMenu = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(mainMenu);
        }
        else if(lvlDone()){
            Intent nextLvl = new Intent(getApplicationContext(), nextLevel);
            nextLvl.putExtra("score",topPanel.getScore());
            startActivity(nextLvl);
        }




        clickableOptions.disappear();
        viewableOptions.disappear();
        topPanel.questionDisappear();
        int questionNumber = topPanel.generateQuestion();
        clickableOptions.setCorrectAnswer(correctAnswers.get(questionNumber));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                topPanel.questionAppear();
            }
        },1000);

        //error here!!!!
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                viewableOptions.appear();
                clickableOptions.appear();
                if(clickableOptions.isCorrect()){
                    topPanel.increaseScore(1);
                    startLvl();
                }
                else{
                    topPanel.decreaseScore(1);
                    startLvl();
                }
            }
        },2000);

/*
        */
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
