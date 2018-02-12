package com.example.tie.criscros.registration.mvp;


import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(SkipStrategy.class)
public interface RegistrationView extends MvpView {
    void success();
    void mainMenu();
    void error(String massage);
}
