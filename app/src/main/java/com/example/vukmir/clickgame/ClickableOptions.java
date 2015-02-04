package com.example.vukmir.clickgame;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class ClickableOptions extends Activity{
    List<Button> clickableOptions = new ArrayList<>();
    Answer correctAnswer;

    public ClickableOptions(List<Button> clickableOptions) {
        if(clickableOptions == null)
            throw new NullPointerException("clickableOptions null");
        else
            this.clickableOptions.addAll(clickableOptions);
    }

    public Button getOption(int i){
        if(i<0 || i>clickableOptions.size()){
            throw new IndexOutOfBoundsException("out of boundaries");
        }
        return clickableOptions.get(i);
    }

    public void appear(){
        for(Button b : clickableOptions){
            b.setVisibility(View.VISIBLE);
        }
    }

    public void disappear(){
        for(Button b : clickableOptions){
            b.setVisibility(View.INVISIBLE);
        }
    }

    public Answer getAnswer(){
        final Answer answer = new Answer();
        /*for(final Button b : clickableOptions){
            b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    answer.setAnswer(clickableOptions.indexOf(b));
                    Toast.makeText(getApplicationContext(),""+clickableOptions.indexOf(b),Toast.LENGTH_SHORT).show();
                }
            })
        }
        */
        clickableOptions.get(0).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                answer.setAnswer(0);
            }
        });
        return answer;
    }

    public void setCorrectAnswer(Answer correctAnswer){
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(){
        if(getAnswer().checkAnswer(correctAnswer))
            return true;
        else
            return false;
    }
}
