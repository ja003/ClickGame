package com.example.vukmir.clickgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button startButton = (Button) findViewById(R.id.btnStart);
    startButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent lvl01 = new Intent(getApplicationContext(), Lvl_01.class);
            score = 0;
            lvl01.putExtra("score", score);

            startActivity(lvl01);

            //overridePendingTransition(R.animator.animation_01,R.animator.animation_01);
        }

    });






    }



}
