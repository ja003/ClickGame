package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Lvl_02 extends Activity { //has to be declared in android manifest!



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl_02);

        //get score from lvl before
        final int scoreCurrent = getIntent().getIntExtra("score",-1);

        final TextView scoreView = (TextView) findViewById(R.id.score);
        //Toast.makeText(getApplicationContext(),"it is" + scoreLvl1 ,Toast.LENGTH_LONG).show();
        scoreView.setText(" " + scoreCurrent);


        //quest appears after 2 seconds
        final TextView quest = (TextView) findViewById(R.id.txtQuest);
        quest.postDelayed(new Runnable() {
            @Override
            public void run() {
                quest.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(),toString(quest_01.getAlpha()),Toast.LENGTH_SHORT);
            }
        }, 1000);

        //boxes appears after 4 seconds
        final ImageView red_box = (ImageView) findViewById(R.id.boxRed);
        final ImageView blue_box = (ImageView) findViewById(R.id.boxBlue);
        final ImageView yellow_box = (ImageView) findViewById(R.id.boxYellow);
        final ImageView green_box = (ImageView) findViewById(R.id.boxGreen);
        red_box.postDelayed(new Runnable() {
            @Override
            public void run() {
                red_box.setVisibility(View.VISIBLE);
                blue_box.setVisibility(View.VISIBLE);
                yellow_box.setVisibility(View.VISIBLE);
                green_box.setVisibility(View.VISIBLE);
            }
        }, 2000);

        // correct box option
        blue_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getApplicationContext(), Lvl_01.class);
                //startActivity(intent);
                //Toast.makeText(getApplicationContext(),"YOU WON!", Toast.LENGTH_LONG).show();
                scoreView.setText(" " + (scoreCurrent+1) );
            }

        });

        // wrong boxes options
        red_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"YOU LOST", Toast.LENGTH_SHORT).show();
                scoreView.setText(" " + (scoreCurrent-1) );
            }

        });



    }

    //************end of onCreate ************//

}