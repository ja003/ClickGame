package com.example.vukmir.clickgame;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class Score {
    public int score;

    public Score(int score) {
        this.score = score;
    }

    public void increaseScore(int i){
        score = score + i;
    }

    public void decreaseScore(int i){
        score = score - i;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
