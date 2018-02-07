package com.example.tie.criscros.game.mvp;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface GameView extends MvpView {

    void nextMove(String s,int i, int j);

    void checkWin(String s);

    void disableField();

}
