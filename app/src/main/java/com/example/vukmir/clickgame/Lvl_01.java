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

    int LOSE_SCORE = 0;
    int WIN_SCORE = 5;
    int QUESTIONS_COUNT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl_01);

        //get score from lvl before
        //Score score = new Score(getIntent().getIntExtra("score", -1));
        int score = (getIntent().getIntExtra("score", -1));

        //get clickable options
        Button clickableOption01 = (Button) findViewById(R.id.btnOpt01);
        Button clickableOption02 = (Button) findViewById(R.id.btnOpt02);
        Button clickableOption03 = (Button) findViewById(R.id.btnOpt03);
        Button clickableOption04 = (Button) findViewById(R.id.btnOpt04);
        List<Button> clickableOptionsList = new ArrayList<>();
        clickableOptionsList.add(clickableOption01);
        clickableOptionsList.add(clickableOption02);
        clickableOptionsList.add(clickableOption03);
        clickableOptionsList.add(clickableOption04);

        ClickableOptions clickableOptions = new ClickableOptions(clickableOptionsList);

        //get viewable options
        RelativeLayout viewableOption01 = (RelativeLayout) findViewById(R.id.viewableOpt01);
        RelativeLayout viewableOption02 = (RelativeLayout) findViewById(R.id.viewableOpt02);
        List<RelativeLayout> viewableOptionsList = new ArrayList<>();
        viewableOptionsList.add(viewableOption01);
        viewableOptionsList.add(viewableOption02);

        ViewableOptions viewableOptions = new ViewableOptions(viewableOptionsList);

        //get top panel
        TextView scoreView = (TextView) findViewById(R.id.scoreView);
        TextView questionView = (TextView) findViewById(R.id.txtQuest);
        //create question list
        List<String> questions = new ArrayList<>();
        questions.add("Click on red box");
        questions.add("Click on blue box");

        TopPanel topPanel = new TopPanel(questionView,scoreView,score, QUESTIONS_COUNT, questions);
        //create correct answers list
        List<Answer> correctAnswers = new ArrayList<>();
        correctAnswers.add(new Answer(1));
        correctAnswers.add(new Answer(2));

        //create level
        Level level01 = new Level(LOSE_SCORE, WIN_SCORE, clickableOptions, viewableOptions, topPanel, Lvl_02.class, correctAnswers);
        level01.startLvl();



    }
    //************end of onCreate ************//


}


