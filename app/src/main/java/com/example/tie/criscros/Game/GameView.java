package com.example.tie.criscros.Game;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
interface GameView extends MvpView {

    void nextMove(String s,int i, int j);

    void checkWin(String s);

    void disableField();

}
