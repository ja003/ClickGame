package com.example.vukmir.clickgame;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class Level {
    Score score;
    ClickableOptions clickableOptions;
    ViewableOptions viewableOptions;
    public Level(Score score, ClickableOptions clickableOptions, ViewableOptions viewableOptions) {
        this.score = score;
        this.clickableOptions = clickableOptions;
        this.viewableOptions = viewableOptions;
    }


}
