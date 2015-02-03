package com.example.vukmir.clickgame;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class ClickableOptions {
    List<Button> clickableOptions = new ArrayList<>();
    Answer correctAnswer;

    public ClickableOptions(List<Button> clickableOptions) {
        if(clickableOptions == null)
            throw new NullPointerException("clickableOptions null");
        else
            this.clickableOptions.addAll(clickableOptions);
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
        for(final Button b : clickableOptions){
            b.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    answer.setAnswer(clickableOptions.indexOf(b));
                }
            });
        }
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
