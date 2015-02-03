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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Lvl_01 extends Activity { //has to be declared in android manifest!



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lvl_01);

        //get score from lvl before
        final int scoreCurrent = getIntent().getIntExtra("score",-1);

        final TextView scoreView = (TextView) findViewById(R.id.score);
        //Toast.makeText(getApplicationContext(),"it is" + scoreCurrent ,Toast.LENGTH_LONG).show();
        scoreView.setText(" " + scoreCurrent);


        //quest appears after 1 seconds
        final TextView quest = (TextView) findViewById(R.id.txtQuest);
        quest.postDelayed(new Runnable() {
            @Override
            public void run() {
                quest.setVisibility(View.VISIBLE);
                //Toast.makeText(getApplicationContext(),toString(quest_01.getAlpha()),Toast.LENGTH_SHORT);
            }
        }, 1000);

        //boxes appears after 2 seconds
        final RelativeLayout optionsClickable = (RelativeLayout) findViewById(R.id.questOptionsClickable);

        final ImageView red_box = (ImageView) findViewById(R.id.boxRed);
        final ImageView blue_box = (ImageView) findViewById(R.id.boxBlue);
        final ImageView yellow_box = (ImageView) findViewById(R.id.boxYellow);
        final ImageView green_box = (ImageView) findViewById(R.id.boxGreen);
        red_box.postDelayed(new Runnable() {
            @Override
            public void run() {
                optionsClickable.setVisibility(View.VISIBLE);
                optionsClickable.setAlpha(1);

                red_box.setVisibility(View.VISIBLE);
                blue_box.setVisibility(View.VISIBLE);
                yellow_box.setVisibility(View.VISIBLE);
                green_box.setVisibility(View.VISIBLE);
            }
        }, 2000);

        // correct box option
        red_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lvl_01.class);
                intent.putExtra("score", scoreCurrent+1);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"YOU WON!", Toast.LENGTH_LONG).show();
                scoreView.setText(" " + (scoreCurrent+1) );
            }

        });

        // wrong boxes options
        blue_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Lvl_02.class);
                intent.putExtra("score", scoreCurrent-1);
                startActivity(intent);
                //Toast.makeText(getApplicationContext(),"YOU WON!", Toast.LENGTH_LONG).show();
                scoreView.setText(" " + (scoreCurrent - 1));
            }

        });



    }

    //************end of onCreate ************//

}