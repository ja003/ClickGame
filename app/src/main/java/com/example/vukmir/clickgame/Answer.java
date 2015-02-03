package com.example.vukmir.clickgame;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class Answer {
    int answer;
    public Answer() {

    }

    public Answer(int answer) {
        this.answer = answer;
    }

    public boolean checkAnswer(Answer correctAnswer){
        if(answer == correctAnswer.getAnswer())
            return true;
        else
            return false;
    }

    public boolean checkAnswer(int correctAnswer){
        if(answer == correctAnswer)
            return true;
        else
            return false;
    }


    public int getAnswer(){
        return answer;
    }

    public void setAnswer(int answer){
        this.answer = answer;
    }

    public boolean equals(Object obj){
        if(obj instanceof Answer){
            Answer answer = (Answer) obj;
            if(this.answer == answer.answer){
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hash = 5;
        hash = 79*hash+(this.answer);
        return hash;
    }

}
