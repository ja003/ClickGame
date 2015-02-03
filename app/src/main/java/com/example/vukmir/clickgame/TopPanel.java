package com.example.vukmir.clickgame;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class TopPanel extends Activity{
    TextView questionView;
    TextView scoreView;
    int score;
    int questionsCount;
    List<String> questions = new ArrayList<>();

    public TopPanel(TextView questionView, TextView scoreView, int score, int questionsCount, List<String> questions) {
        this.questionView = questionView;
        this.scoreView = scoreView;
        this.score = score;
        this.questionsCount = questionsCount;
        if(questions == null)
            throw new NullPointerException("questions null");
        else
            this.questions.addAll(questions);
    }

    public void questionDisappear(){
        questionView.setVisibility(View.INVISIBLE);
    }
    public void questionAppear(){
        questionView.setVisibility(View.VISIBLE);
    }

    public String getQuestion(int i){
        return questions.get(i);
    }

    public int generateQuestion(){
        Random randomGenerator = new Random();
        int questNumber = randomGenerator.nextInt(questionsCount);
        setQuestion(getQuestion(questNumber));
        return questNumber;
    }

    public void setQuestion(String question){
        this.questionView.setText(question);
    }

    public int getScore(){
        return score;
    }
    public void setScore(int i){
        score = i;
    }

    public void increaseScore(int i){
        score += i;
        this.scoreView.setText(""+score);
    }
    public void decreaseScore(int i){
        score -= i;
        this.scoreView.setText(""+score);
    }
}
