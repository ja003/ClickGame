package com.example.vukmir.clickgame;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vukmir on 3.2.2015.
 */
public class ViewableOptions {
    List<RelativeLayout> viewableOptions = new ArrayList<>();

    public ViewableOptions(List<RelativeLayout> viewableOptions) {
        if(viewableOptions == null)
            throw new NullPointerException("viewableOptions null");
        else
            this.viewableOptions.addAll(viewableOptions);
    }

    public void appear(){
        for(RelativeLayout r : viewableOptions){
            r.setVisibility(View.VISIBLE);
        }
    }

    public void disappear(){
        for(RelativeLayout r : viewableOptions){
            r.setVisibility(View.INVISIBLE);
        }
    }
}
